package com.uptech.windalerts.infrastructure.endpoints

import cats.effect.Effect
import cats.implicits._
import com.uptech.windalerts.core.BeachNotFoundError
import com.uptech.windalerts.core.beaches.BeachService
import codecs._
import com.uptech.windalerts.core.beaches.domain.BeachId
import io.circe.syntax.EncoderOps
import org.http4s.Request
import org.http4s.rho.RhoRoutes

class BeachesEndpointsRho[F[+_] : Effect](B: BeachService[F]) extends RhoRoutes[F] {


  val id = pathVar[Int]("id")


  val statusById = "status" / id

  GET / statusById |>> { (_: Request[F], id: Int) => {
    B.get(BeachId(id)).value.flatMap {
      case Right(value) => Ok(value)
      case Left(BeachNotFoundError(_)) => NotFound(s"Beach not found $id")
    }
  }
  }


}
