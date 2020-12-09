package com.uptech.windalerts.otp

import cats.data.EitherT
import com.uptech.windalerts.domain.OtpNotFoundError

trait OtpRepository[F[_]] {
  def exists(otp: String, userId: String): EitherT[F, OtpNotFoundError, OTPWithExpiry]

  def updateForUser(userId:String, otp: OTPWithExpiry): F[OTPWithExpiry]
}