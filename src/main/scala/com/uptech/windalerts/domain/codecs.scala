package com.uptech.windalerts.domain

import com.uptech.windalerts.alerts.domain.{AlertT}
import com.uptech.windalerts.alerts.{TimeRange}
import com.uptech.windalerts.credentials.{AppleCredentials, Credentials, FacebookCredentials}
import com.uptech.windalerts.feedback.Feedback
import com.uptech.windalerts.notifications.Notification
import com.uptech.windalerts.otp.OTPWithExpiry
import com.uptech.windalerts.social.subcriptions.{AndroidToken, AppleToken}
import com.uptech.windalerts.tokens.RefreshToken
import com.uptech.windalerts.users.UserT
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.mongodb.scala.bson.codecs.DEFAULT_CODEC_REGISTRY
import org.mongodb.scala.bson.codecs.Macros._

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
    fromProviders(classOf[TimeRange]),
    fromProviders(classOf[FacebookCredentials]),
    fromProviders(classOf[AppleToken]),
    fromProviders(classOf[AppleCredentials]),
    fromProviders(classOf[Feedback]),
    DEFAULT_CODEC_REGISTRY)
}