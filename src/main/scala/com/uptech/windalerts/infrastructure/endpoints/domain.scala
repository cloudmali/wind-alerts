package com.uptech.windalerts.infrastructure.endpoints
import com.uptech.windalerts.alerts.TimeRange
import io.scalaland.chimney.dsl._

object domain {
  case class UpdateUserRequest(name: String, userType: String, snoozeTill: Long, disableAllAlerts: Boolean, notificationsPerHour: Long)

  case class AccessTokenRequest(refreshToken: String)

  case class FacebookRegisterRequest(accessToken: String, deviceType: String, deviceToken: String) {
    def asDomain(): com.uptech.windalerts.social.login.domain.FacebookAccessRequest  = {
      this.into[com.uptech.windalerts.social.login.domain.FacebookAccessRequest].transform
    }
  }

  case class AppleRegisterRequest(authorizationCode: String, nonce: String, deviceType: String, deviceToken: String, name: String) {
    def asDomain(): com.uptech.windalerts.social.login.domain.AppleAccessRequest  = {
      this.into[com.uptech.windalerts.social.login.domain.AppleAccessRequest].transform
    }
  }

  case class RegisterRequest(email: String, name: String, password: String, deviceType: String, deviceToken: String)

  case class LoginRequest(email: String, password: String, deviceType: String, deviceToken: String)

  case class ChangePasswordRequest(email: String, oldPassword: String, newPassword: String, deviceType: String)

  case class ResetPasswordRequest(email: String, deviceType: String)

  case class FeedbackRequest(topic: String, message: String)

  case class Alerts(alerts: Seq[Alert])


  final case class UserDTO(id: String, email: String, name: String, deviceToken: String, deviceType: String, startTrialAt: Long, endTrialAt: Long, userType: String, snoozeTill: Long, disableAllAlerts: Boolean, notificationsPerHour: Long, lastPaymentAt: Long, nextPaymentAt: Long) {
    def this(id: String, email: String, name: String, deviceToken: String, deviceType: String, startTrialAt: Long, userType: String, snoozeTill: Long, disableAllAlerts: Boolean, notificationsPerHour: Long) =
      this(id, email, name, deviceToken, deviceType, startTrialAt, if (startTrialAt == -1) -1L else (startTrialAt + (30L * 24L * 60L * 60L * 1000L)), userType, snoozeTill, disableAllAlerts, notificationsPerHour, -1, -1)
  }

  case class TokensWithUser(accessToken: String, refreshToken: String, expiredAt: Long, user: UserDTO)

  final case class OTP(otp: String)



  case class AlertRequest(
                           beachId: Long,
                           days: Seq[Long],
                           swellDirections: Seq[String],
                           timeRanges: Seq[TimeRange],
                           waveHeightFrom: Double,
                           waveHeightTo: Double,
                           windDirections: Seq[String],
                           tideHeightStatuses: Seq[String] = Seq("Rising", "Falling"),
                           enabled: Boolean,
                           timeZone: String = "Australia/Sydney")


  case class Alert(
                    id: String,
                    owner: String,
                    beachId: Long,
                    days: Seq[Long],
                    swellDirections: Seq[String],
                    timeRanges: Seq[TimeRange],
                    waveHeightFrom: Double,
                    waveHeightTo: Double,
                    windDirections: Seq[String],
                    tideHeightStatuses: Seq[String] = Seq("Rising", "Falling"),
                    enabled: Boolean,
                    timeZone: String = "Australia/Sydney") {
  }


  case class AndroidUpdate(message: Message)

  case class Message(data: String)


  case class AndroidReceiptValidationRequest(productId: String, token: String)

  case class ApplePurchaseToken(token: String)

  case class UserId(id: String)



  final case class BeachId(id: Long) extends AnyVal

  final case class Wind(direction: Double = 0, speed: Double = 0, directionText: String)

  final case class Swell(height: Double = 0, direction: Double = 0, directionText: String)

  final case class TideHeight(height: Double, status: String, nextLow: Long, nextHigh: Long)

  final case class SwellOutput(height: Double = 0, direction: Double = 0, directionText: String)

  final case class Tide(height: TideHeight, swell: SwellOutput)

  final case class Beach(beachId: BeachId, wind: Wind, tide: Tide)

}

