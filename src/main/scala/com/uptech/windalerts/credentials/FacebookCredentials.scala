package com.uptech.windalerts.credentials

import org.mongodb.scala.bson.ObjectId


case class FacebookCredentials(override val _id: ObjectId, override val email: String, override val socialId: String, override val deviceType: String) extends SocialCredentials

object FacebookCredentials {
  def apply(email: String, socialId: String, deviceType: String): FacebookCredentials = new FacebookCredentials(new ObjectId(), email, socialId, deviceType)
}
