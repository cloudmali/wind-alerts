package com.uptech.windalerts.social.subcriptions

import org.mongodb.scala.bson.ObjectId


case class AppleToken(_id: ObjectId,
                      userId: String,
                      purchaseToken: String,
                      creationTime: Long
                     )

object AppleToken {
  def apply(userId: String, purchaseToken: String, creationTime: Long): AppleToken = new AppleToken(new ObjectId(), userId, purchaseToken, creationTime)
}
