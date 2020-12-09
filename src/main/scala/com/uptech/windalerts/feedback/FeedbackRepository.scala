package com.uptech.windalerts.feedback


trait FeedbackRepository[F[_]] {
  def create(credentials: Feedback): F[Feedback]
}