package com.uptech.windalerts.credentials

import org.mongodb.scala.bson.ObjectId


case class Credentials(_id: ObjectId, email: String, password: String, deviceType: String)

object Credentials {
  def apply(email: String, password: String, deviceType: String): Credentials = new Credentials(new ObjectId(), email, password, deviceType)
}
