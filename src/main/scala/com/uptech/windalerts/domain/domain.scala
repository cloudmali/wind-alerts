package com.uptech.windalerts.domain

import cats.data.EitherT


object domain {
  type SurfsUpEitherT[F[_], T] = EitherT[F, SurfsUpError, T]
}