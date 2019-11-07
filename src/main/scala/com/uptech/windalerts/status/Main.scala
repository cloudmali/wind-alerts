package com.uptech.windalerts.status

import cats.effect.{IO, _}
import cats.implicits._
import com.uptech.windalerts.domain.codecs._
import com.uptech.windalerts.domain.domain.BeachId
import com.uptech.windalerts.domain.{HttpErrorHandler, secrets, swellAdjustments}
import org.http4s.HttpRoutes
import org.http4s.dsl.impl.Root
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder
import org.log4s.getLogger
object  Main extends IOApp {
  private val logger = getLogger

  def allRoutes( B: Beaches.Service, H:HttpErrorHandler[IO]) = HttpRoutes.of[IO] {
    case GET -> Root / "v1" / "beaches" / IntVar(id) / "currentStatus" =>
      Ok(B.get(BeachId(id)))
    case GET -> Root / "beaches" / IntVar(id) / "currentStatus" =>
      Ok(B.get(BeachId(id)))
  }

  def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(getLogger.error("Starting"))
      conf <- IO(secrets.read)
      apiKey <- IO(conf.surfsUp.willyWeather.key)
      beaches <- IO(Beaches.ServiceImpl(Winds.impl(apiKey), Swells.impl(apiKey, swellAdjustments.read), Tides.impl(apiKey)))
      httpErrorHandler <- IO(new HttpErrorHandler[IO])
      server <- BlazeServerBuilder[IO]
        .bindHttp(sys.env("PORT").toInt, "0.0.0.0")
        .withHttpApp(com.uptech.windalerts.domain.commons.tracingMiddleware(allRoutes( beaches, httpErrorHandler)).orNotFound)
        .serve
        .compile
        .drain
        .as(ExitCode.Success)
    } yield server
  }

}