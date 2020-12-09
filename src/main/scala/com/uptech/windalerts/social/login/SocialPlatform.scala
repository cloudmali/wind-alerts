package com.uptech.windalerts.social.login

import com.uptech.windalerts.domain.domain.SurfsUpEitherT
import com.uptech.windalerts.social.login.domain.AccessRequest

trait SocialPlatform[F[_], T <: AccessRequest] {
  def fetchUserFromPlatform(registerRequest: T): SurfsUpEitherT[F, SocialUser]
}