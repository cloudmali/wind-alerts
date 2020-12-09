package com.uptech.windalerts.infrastructure.endpoints
import com.uptech.windalerts.domain.domain.Alert
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

}

