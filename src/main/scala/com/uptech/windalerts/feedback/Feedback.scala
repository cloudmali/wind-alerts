package com.uptech.windalerts.feedback

import org.mongodb.scala.bson.ObjectId


case class Feedback(_id: ObjectId, topic: String, message: String, userId: String)

object Feedback {
  def apply(topic: String, message: String, userId: String): Feedback = new Feedback(new ObjectId, topic, message, userId)
}
