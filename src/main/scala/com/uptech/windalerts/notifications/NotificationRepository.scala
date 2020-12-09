package com.uptech.windalerts.notifications

import cats.data.EitherT
import com.uptech.windalerts.notifications.NotificationRepository.UserWithCount

trait NotificationRepository[F[_]] {
  def create(notifications: Notification): F[Notification]
  def countNotificationInLastHour(userId: String): EitherT[F, Exception, UserWithCount]
}

object NotificationRepository {
  final case class UserWithCount(userId: String, count: Int)
}