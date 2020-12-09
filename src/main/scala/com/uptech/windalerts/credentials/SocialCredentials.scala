package com.uptech.windalerts.credentials

import org.mongodb.scala.bson.ObjectId


trait SocialCredentials {
  def _id: ObjectId

  def email: String

  def socialId: String

  def deviceType: String
}