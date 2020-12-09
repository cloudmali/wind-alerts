package com.uptech.windalerts.credentials

import org.mongodb.scala.bson.ObjectId


case class AppleCredentials(override val _id: ObjectId, override val email: String, override val socialId: String, override val deviceType: String) extends SocialCredentials

object AppleCredentials {
  def apply(email: String, socialId: String, deviceType: String): AppleCredentials = new AppleCredentials(new ObjectId(), email, socialId, deviceType)
}