package com.uptech.windalerts.infrastructure.endpoints

import cats.Applicative
import cats.effect.Sync
import com.uptech.windalerts.alerts.TimeRange
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

  lazy implicit val userDecoder: Decoder[UserDTO] = deriveDecoder[UserDTO]
  implicit def userEntityDecoder[F[_] : Sync]: EntityDecoder[F, UserDTO] = jsonOf
  lazy implicit val userEncoder: Encoder[UserDTO] = deriveEncoder[UserDTO]
  implicit def userEntityEncoder[F[_] : Applicative]: EntityEncoder[F, UserDTO] = jsonEncoderOf


  lazy implicit val tokensDecoder: Decoder[TokensWithUser] = deriveDecoder[TokensWithUser]
  implicit def tokensEntityDecoder[F[_] : Sync]: EntityDecoder[F, TokensWithUser] = jsonOf
  lazy implicit val tokenEncoder: Encoder[TokensWithUser] = deriveEncoder[TokensWithUser]
  implicit def tokensEntityEncoder[F[_] : Applicative]: EntityEncoder[F, TokensWithUser] = jsonEncoderOf



  lazy implicit val otpDecoder: Decoder[OTP] = deriveDecoder[OTP]
  implicit def otpEntityDecoder[F[_] : Sync]: EntityDecoder[F, OTP] = jsonOf


  lazy implicit val s1androidReceiptValidationRequestDecoder: Decoder[AndroidUpdate] = deriveDecoder[AndroidUpdate]
  implicit def s1androidReceiptValidationRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, AndroidUpdate] = jsonOf

  lazy implicit val ms1androidReceiptValidationRequestDecoder: Decoder[Message] = deriveDecoder[Message]
  implicit def ms1androidReceiptValidationRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, Message] = jsonOf


  lazy implicit val androidReceiptValidationRequestDecoder: Decoder[AndroidReceiptValidationRequest] = deriveDecoder[AndroidReceiptValidationRequest]
  implicit def androidReceiptValidationRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, AndroidReceiptValidationRequest] = jsonOf


  lazy implicit val applePurchaseTokenDecoder: Decoder[ApplePurchaseToken] = deriveDecoder[ApplePurchaseToken]
  implicit def applePurchaseTokenEntityDecoder[F[_] : Sync]: EntityDecoder[F, ApplePurchaseToken] = jsonOf



  lazy implicit val beachIdDecoder: Decoder[BeachId] = deriveDecoder[BeachId]
  implicit def beachIdEntityDecoder[F[_] : Sync]: EntityDecoder[F, BeachId] = jsonOf
  lazy implicit val beachIdEncoder: Encoder[BeachId] = deriveEncoder[BeachId]
  implicit def beachIdEntityDecoderEncoder[F[_] : Applicative]: EntityEncoder[F, BeachId] = jsonEncoderOf

  lazy implicit val beachDecoder: Decoder[Beach] = deriveDecoder[Beach]
  implicit def beachEntityDecoder[F[_] : Sync]: EntityDecoder[F, Beach] = jsonOf
  lazy implicit val beachEncoder: Encoder[Beach] = deriveEncoder[Beach]
  implicit def beachEntityEncoder[F[_] : Applicative]: EntityEncoder[F, Beach] = jsonEncoderOf

  lazy implicit val swellDecoder: Decoder[Swell] = deriveDecoder[Swell]
  implicit def swellEntityDecoder[F[_] : Sync]: EntityDecoder[F, Swell] = jsonOf
  lazy implicit val swellEncoder: Encoder[Swell] = deriveEncoder[Swell]
  implicit def swellEntityEncoder[F[_] : Applicative]: EntityEncoder[F, Swell] = jsonEncoderOf

  lazy implicit val windDecoder: Decoder[Wind] = deriveDecoder[Wind]
  implicit def windEntityDecoder[F[_] : Sync]: EntityDecoder[F, Wind] = jsonOf
  lazy implicit val windEncoder: Encoder[Wind] = deriveEncoder[Wind]
  implicit def windEntityEncoder[F[_] : Applicative]: EntityEncoder[F, Wind] = jsonEncoderOf

  lazy implicit val tideDecoder: Decoder[Tide] = deriveDecoder[Tide]
  implicit def tideEntityDecoder[F[_] : Sync]: EntityDecoder[F, Tide] = jsonOf
  lazy implicit val tideEncoder: Encoder[Tide] = deriveEncoder[Tide]
  implicit def tideEntityEncoder[F[_] : Applicative]: EntityEncoder[F, Tide] = jsonEncoderOf


  lazy implicit val swellODecoder: Decoder[SwellOutput] = deriveDecoder[SwellOutput]
  implicit def swellOEntityDecoder[F[_] : Sync]: EntityDecoder[F, SwellOutput] = jsonOf
  lazy implicit val swellOEncoder: Encoder[SwellOutput] = deriveEncoder[SwellOutput]
  implicit def swellOEntityEncoder[F[_] : Applicative]: EntityEncoder[F, SwellOutput] = jsonEncoderOf


  lazy implicit val tideHeightDecoder: Decoder[TideHeight] = deriveDecoder[TideHeight]
  implicit def tideHeightEntityDecoder[F[_] : Sync]: EntityDecoder[F, TideHeight] = jsonOf
  lazy implicit val tideHeightEncoder: Encoder[TideHeight] = deriveEncoder[TideHeight]
  implicit def tideHeightEntityEncoder[F[_] : Applicative]: EntityEncoder[F, TideHeight] = jsonEncoderOf


}

