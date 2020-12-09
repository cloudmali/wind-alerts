package com.uptech.windalerts.domain

import cats.Applicative
import cats.effect.Sync
import com.uptech.windalerts.alerts.TimeRange
import com.uptech.windalerts.alerts.domain.AlertT
import com.uptech.windalerts.credentials.{AppleCredentials, Credentials, FacebookCredentials}
import com.uptech.windalerts.domain.domain._
import com.uptech.windalerts.feedback.Feedback
import com.uptech.windalerts.notifications.Notification
import com.uptech.windalerts.otp.OTPWithExpiry
import com.uptech.windalerts.social.subcriptions.{AndroidToken, AppleToken}
import com.uptech.windalerts.tokens.RefreshToken
import com.uptech.windalerts.users.UserT
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}
import org.http4s.circe.{jsonEncoderOf, jsonOf}
import org.http4s.{EntityDecoder, EntityEncoder}
import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.bson.codecs.DEFAULT_CODEC_REGISTRY
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}

object codecs {
  Notification
  val codecRegistry = fromRegistries(
    fromProviders(classOf[Notification]),
    fromProviders(classOf[OTPWithExpiry]),
    fromProviders(classOf[AndroidToken]),
    fromProviders(classOf[RefreshToken]),
    fromProviders(classOf[UserT]),
    fromProviders(classOf[Credentials]),
    fromProviders(classOf[AlertT]),
    fromProviders(classOf[AlertsT]),
    fromProviders(classOf[TimeRange]),
    fromProviders(classOf[FacebookCredentials]),
    fromProviders(classOf[AppleToken]),
    fromProviders(classOf[AppleCredentials]),
    fromProviders(classOf[Feedback]),
    DEFAULT_CODEC_REGISTRY)


  lazy implicit val sandroidReceiptValidationRequestDecoder: Decoder[SubscriptionPurchase] = deriveDecoder[SubscriptionPurchase]

  implicit def sandroidReceiptValidationRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, SubscriptionPurchase] = jsonOf

  lazy implicit val sandroidReceiptValidationRequestEncoder: Encoder[SubscriptionPurchase] = deriveEncoder[SubscriptionPurchase]

  implicit def sandroidReceiptValidationRequestEntityEncoder[F[_] : Applicative]: EntityEncoder[F, SubscriptionPurchase] = jsonEncoderOf

  lazy implicit val beachIdDecoder: Decoder[BeachId] = deriveDecoder[BeachId]

  implicit def beachIdEntityDecoder[F[_] : Sync]: EntityDecoder[F, BeachId] = jsonOf

  lazy implicit val beachIdEncoder: Encoder[BeachId] = deriveEncoder[BeachId]

  implicit def beachIdEntityEncoder[F[_] : Applicative]: EntityEncoder[F, BeachId] = jsonEncoderOf

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

  lazy implicit val otpEncoder: Encoder[OTP] = deriveEncoder[OTP]

  implicit def otpEncoder[F[_] : Applicative]: EntityEncoder[F, OTP] = jsonEncoderOf


  lazy implicit val androidReceiptValidationRequestDecoder: Decoder[AndroidReceiptValidationRequest] = deriveDecoder[AndroidReceiptValidationRequest]

  implicit def androidReceiptValidationRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, AndroidReceiptValidationRequest] = jsonOf

  lazy implicit val androidReceiptValidationRequestEncoder: Encoder[AndroidReceiptValidationRequest] = deriveEncoder[AndroidReceiptValidationRequest]

  implicit def androidReceiptValidationRequestEncoder[F[_] : Applicative]: EntityEncoder[F, AndroidReceiptValidationRequest] = jsonEncoderOf

  lazy implicit val s1androidReceiptValidationRequestDecoder: Decoder[AndroidUpdate] = deriveDecoder[AndroidUpdate]

  implicit def s1androidReceiptValidationRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, AndroidUpdate] = jsonOf

  lazy implicit val s1androidReceiptValidationRequestEncoder: Encoder[AndroidUpdate] = deriveEncoder[AndroidUpdate]

  implicit def s1androidReceiptValidationRequestEncoder[F[_] : Applicative]: EntityEncoder[F, AndroidUpdate] = jsonEncoderOf

  lazy implicit val ms1androidReceiptValidationRequestDecoder: Decoder[Message] = deriveDecoder[Message]

  implicit def ms1androidReceiptValidationRequestEntityDecoder[F[_] : Sync]: EntityDecoder[F, Message] = jsonOf

  lazy implicit val ms1androidReceiptValidationRequestEncoder: Encoder[Message] = deriveEncoder[Message]

  implicit def ms1androidReceiptValidationRequestEncoder[F[_] : Applicative]: EntityEncoder[F, Message] = jsonEncoderOf


  lazy implicit val subscriptionNotificationDecoder: Decoder[SubscriptionNotification] = deriveDecoder[SubscriptionNotification]

  implicit def subscriptionNotificationEntityDecoder[F[_] : Sync]: EntityDecoder[F, SubscriptionNotification] = jsonOf

  lazy implicit val subscriptionNotificationEncoder: Encoder[SubscriptionNotification] = deriveEncoder[SubscriptionNotification]

  implicit def subscriptionNotificationEncoder[F[_] : Applicative]: EntityEncoder[F, SubscriptionNotification] = jsonEncoderOf


  lazy implicit val subscriptionNotificationWrapperDecoder: Decoder[SubscriptionNotificationWrapper] = deriveDecoder[SubscriptionNotificationWrapper]

  implicit def subscriptionNotificationWrapperEntityDecoder[F[_] : Sync]: EntityDecoder[F, SubscriptionNotificationWrapper] = jsonOf

  lazy implicit val subscriptionNotificationWrapperEncoder: Encoder[SubscriptionNotificationWrapper] = deriveEncoder[SubscriptionNotificationWrapper]

  implicit def subscriptionNotificationWrapperEncoder[F[_] : Applicative]: EntityEncoder[F, SubscriptionNotificationWrapper] = jsonEncoderOf


  lazy implicit val appleSubscriptionPurchaseDecoder: Decoder[AppleSubscriptionPurchase] = deriveDecoder[AppleSubscriptionPurchase]

  implicit def appleSubscriptionPurchaseEntityDecoder[F[_] : Sync]: EntityDecoder[F, AppleSubscriptionPurchase] = jsonOf

  lazy implicit val appleSubscriptionPurchaseEncoder: Encoder[AppleSubscriptionPurchase] = deriveEncoder[AppleSubscriptionPurchase]

  implicit def appleSubscriptionPurchaseEnityEncoder[F[_] : Applicative]: EntityEncoder[F, AppleSubscriptionPurchase] = jsonEncoderOf


  lazy implicit val applePurchaseTokenDecoder: Decoder[ApplePurchaseToken] = deriveDecoder[ApplePurchaseToken]

  implicit def applePurchaseTokenEntityDecoder[F[_] : Sync]: EntityDecoder[F, ApplePurchaseToken] = jsonOf

  lazy implicit val applePurchaseTokenEncoder: Encoder[ApplePurchaseToken] = deriveEncoder[ApplePurchaseToken]

  implicit def applePurchaseTokenEnityEncoder[F[_] : Applicative]: EntityEncoder[F, ApplePurchaseToken] = jsonEncoderOf




}