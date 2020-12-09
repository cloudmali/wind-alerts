package com.uptech.windalerts.otp

import org.mongodb.scala.bson.ObjectId


case class OTPWithExpiry(_id: ObjectId, otp: String, expiry: Long, userId: String)

  object OTPWithExpiry {
    def apply(otp: String, expiry: Long, userId: String): OTPWithExpiry = new OTPWithExpiry(new ObjectId(), otp, expiry, userId)
  }