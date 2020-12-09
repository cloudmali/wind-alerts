package com.uptech.windalerts.infrastructure.endpoints

import cats.Applicative
import cats.effect.Sync
import com.uptech.windalerts.alerts.TimeRange
import com.uptech.windalerts.domain.domain.{Alert, AlertRequest}
import com.uptech.windalerts.infrastructure.endpoints.domain._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}
import org.http4s.circe.{jsonEncoderOf, jsonOf}
import org.http4s.{EntityDecoder, EntityEncoder}

object codecs {

  lazy implicit val updateUserRequestDecoder: Decoder[UpdateUserRequest] = deriveDecoder[UpdateUserRequest]
  implicit def updateUserRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, UpdateUserRequest] = jsonOf


  lazy implicit val accessTokenRequestDecoder: Decoder[AccessTokenRequest] = deriveDecoder[AccessTokenRequest]
  implicit def accessTokenRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, AccessTokenRequest] = jsonOf

  lazy implicit val srDecoder: Decoder[FacebookRegisterRequest] = deriveDecoder[FacebookRegisterRequest]
  implicit def srEntityDecoder[F[_] : Sync]: EntityDecoder[F, FacebookRegisterRequest] = jsonOf

  lazy implicit val rDecoder: Decoder[RegisterRequest] = deriveDecoder[RegisterRequest]
  implicit def rEntityDecoder[F[_] : Sync]: EntityDecoder[F, RegisterRequest] = jsonOf

  lazy implicit val loginRequestDecoder: Decoder[LoginRequest] = deriveDecoder[LoginRequest]
  implicit def loginRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, LoginRequest] = jsonOf


  lazy implicit val changePasswordRequestDecoder: Decoder[ChangePasswordRequest] = deriveDecoder[ChangePasswordRequest]
  implicit def changePasswordRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, ChangePasswordRequest] = jsonOf

  lazy implicit val resetPasswordRequestDecoder: Decoder[ResetPasswordRequest] = deriveDecoder[ResetPasswordRequest]
  implicit def resetPasswordRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, ResetPasswordRequest] = jsonOf

  lazy implicit val appleRegisterRequestDecoder: Decoder[AppleRegisterRequest] = deriveDecoder[AppleRegisterRequest]
  implicit def appleRegisterRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, AppleRegisterRequest] = jsonOf

  lazy implicit val feedbackRequestDecoder: Decoder[FeedbackRequest] = deriveDecoder[FeedbackRequest]
  implicit def feedbackRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, FeedbackRequest] = jsonOf


  lazy implicit val timeRangeDecoder: Decoder[TimeRange] = deriveDecoder[TimeRange]
  implicit def timeRangeEntityDecoder[F[_] : Sync]: EntityDecoder[F, TimeRange] = jsonOf
  lazy implicit val timeRangeEncoder: Encoder[TimeRange] = deriveEncoder[TimeRange]
  implicit def timeRangeEntityEncoder[F[_] : Applicative]: EntityEncoder[F, TimeRange] = jsonEncoderOf


  lazy implicit val alertDecoder: Decoder[Alert] = deriveDecoder[Alert]
  implicit def alertEntityDecoder[F[_] : Sync]: EntityDecoder[F, Alert] = jsonOf
  lazy implicit val alertEncoder: Encoder[Alert] = deriveEncoder[Alert]
  implicit def alertEntityEncoder[F[_] : Applicative]: EntityEncoder[F, Alert] = jsonEncoderOf

  lazy implicit val alertRDecoder: Decoder[AlertRequest] = deriveDecoder[AlertRequest]
  implicit def alertRntityDecoder[F[_] : Sync]: EntityDecoder[F, AlertRequest] = jsonOf
  lazy implicit val alertREncoder: Encoder[AlertRequest] = deriveEncoder[AlertRequest]
  implicit def alertREntityEncoder[F[_] : Applicative]: EntityEncoder[F, AlertRequest] = jsonEncoderOf

  lazy implicit val salertDecoder: Decoder[Alerts] = deriveDecoder[Alerts]
  implicit def salertEntityDecoder[F[_] : Sync]: EntityDecoder[F, Alerts] = jsonOf
  lazy implicit val salertEncoder: Encoder[Alerts] = deriveEncoder[Alerts]
  implicit def salertEntityEncoder[F[_] : Applicative]: EntityEncoder[F, Alerts] = jsonEncoderOf

}

