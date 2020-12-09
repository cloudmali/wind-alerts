package com.uptech.windalerts.social.subcriptions

import org.mongodb.scala.bson.ObjectId


case class AndroidToken(_id: ObjectId,
                        userId: String,
                        subscriptionId: String,
                        purchaseToken: String,
                        creationTime: Long
                       )

object AndroidToken {
  def apply(userId: String, subscriptionId: String, purchaseToken: String, creationTime: Long): AndroidToken = new AndroidToken(new ObjectId(), userId, subscriptionId, purchaseToken, creationTime)
}