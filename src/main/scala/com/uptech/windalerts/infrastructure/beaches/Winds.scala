package com.uptech.windalerts.infrastructure.beaches

import cats.FlatMap
import cats.data.EitherT
import cats.effect.{Async, ContextShift, Sync}
import com.softwaremill.sttp._
import com.uptech.windalerts.core.beaches.WindsService
import com.uptech.windalerts.core.beaches.domain.BeachId
import com.uptech.windalerts.core.{SurfsUpError, UnknownError}
import com.uptech.windalerts.infrastructure.resilience
import io.circe.generic.semiauto.deriveDecoder
import io.circe.{Decoder, parser}
import org.http4s.EntityDecoder
import org.http4s.circe.jsonOf
import org.log4s.getLogger
import com.uptech.windalerts.core.beaches.domain

import scala.concurrent.Future


case class Wind(
                 speed: Double,
                 gustSpeed: Double,
                 trend: Double,
                 direction: Double,
                 directionText: String
               )

object Wind {

  implicit val windDecoder: Decoder[Wind] = deriveDecoder[Wind]

  implicit def windEntityDecoder[F[_] : Sync]: EntityDecoder[F, Wind] =
    jsonOf
}

class WWBackedWindsService[F[_] : FlatMap : Sync](apiKey: String)(implicit backend: SttpBackend[Id, Nothing], F: Async[F], C: ContextShift[F]) extends WindsService[F] {
  private val logger = getLogger

  override def get(beachId: BeachId): cats.data.EitherT[F, SurfsUpError, domain.Wind] = {

    getFromWillyWeather(beachId)
  }


  def getFromWillyWeather(beachId: BeachId) = {
    val future: Future[Id[Response[String]]] =
      resilience.willyWeatherRequestsDecorator(() => {
        logger.error(s"Fetching wind status for $beachId")
        sttp.get(uri"https://api.willyweather.com.au/v2/$apiKey/locations/${beachId.id}/weather.json?observational=true").send()
      })

    EitherT(F.map(Async.fromFuture(F.pure(future)))(parse(_)))
  }

  private def parse(response: Id[Response[String]]) = {
    val res = for {
      body <- response
        .body
        .left
        .map(left => {
          WillyWeatherHelper.extractError(left)
        })
      parsed <- parser.parse(body).left.map(f => UnknownError(f.message))
      wind <- parsed.hcursor.downField("observational").downField("observations").downField("wind").as[Wind].left.map(f => UnknownError(f.message))
    } yield domain.Wind(wind.direction, wind.speed, wind.directionText, if (wind.trend > 0) "Increasing" else "Decreasing")

    WillyWeatherHelper.leftOnBeachNotFoundError(res, domain.Wind(Double.NaN, Double.NaN, "NA", "NA"))
  }

}

