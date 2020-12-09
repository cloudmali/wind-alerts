package com.uptech.windalerts.tokens

import com.uptech.windalerts.domain.conversions
import org.mongodb.scala.bson.ObjectId


case class RefreshToken(_id: ObjectId, refreshToken: String, expiry: Long, userId: String, accessTokenId: String) {
  def isExpired() = System.currentTimeMillis() > expiry
}

object RefreshToken {
  val REFRESH_TOKEN_EXPIRY = 14L * 24L * 60L * 60L * 1000L

  def apply(userId: String, accessTokenId: String): RefreshToken = new RefreshToken(new ObjectId(),
    conversions.generateRandomString(40),
    System.currentTimeMillis() + REFRESH_TOKEN_EXPIRY,
    userId, accessTokenId)
}