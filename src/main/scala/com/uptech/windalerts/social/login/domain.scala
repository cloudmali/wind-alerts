package com.uptech.windalerts.social.login

object domain {
  sealed trait AccessRequest

  case class FacebookAccessRequest(
        accessToken: String,
        deviceType: String,
        deviceToken: String) extends AccessRequest

  case class AppleAccessRequest(
       authorizationCode: String,
       nonce: String,
       deviceType: String,
       deviceToken: String,
       name: String) extends AccessRequest
}
