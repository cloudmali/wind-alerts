package com.uptech.windalerts.notifications

import org.mongodb.scala.bson.ObjectId


case class Notification(_id: ObjectId, alertId: String, userId: String, deviceToken: String, title: String, body: String, sentAt: Long)

object Notification {
  def apply(alertId: String, userId: String, deviceToken: String, title: String, body: String, sentAt: Long): Notification
  = new Notification(new ObjectId(), alertId, userId, deviceToken, title, body, sentAt)
}