package com.uptech.windalerts.core.otp

import cats.Monad
import cats.implicits._
import com.uptech.windalerts.infrastructure.EmailSender
import com.uptech.windalerts.infrastructure.repositories.mongo.Repos

import scala.util.Random

class OTPService[F[_]](otpRepository: OtpRepository[F], emailSender: EmailSender[F]) {
  def send(userId: String, email: String)(implicit M: Monad[F]):F[Unit] = {
    for {
      otp <- M.pure(createOtp(4))
      _ <- otpRepository.updateForUser(userId, OTPWithExpiry(otp, System.currentTimeMillis() + 5 * 60 * 1000, userId))
      result <- emailSender.sendOtp(email, otp)
    } yield result
  }

  def createOtp(n: Int) = {
    val alpha = "0123456789"
    val size = alpha.size

    (1 to n).map(_ => alpha(Random.nextInt.abs % size)).mkString
  }
}
