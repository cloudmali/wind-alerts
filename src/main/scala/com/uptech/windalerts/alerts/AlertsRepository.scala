package com.uptech.windalerts.alerts

import cats.data.EitherT
import com.uptech.windalerts.alerts.domain.AlertT
import com.uptech.windalerts.domain.SurfsUpError
import com.uptech.windalerts.infrastructure.endpoints.domain.AlertRequest

trait AlertsRepositoryT[F[_]] {
  def disableAllButOneAlerts(userId: String): F[Seq[AlertT]]

  def getAllEnabled(): F[Seq[AlertT]]

  def getAllForUser(user: String): F[Seq[AlertT]]

  def save(alert: AlertRequest, user: String): F[AlertT]

  def delete(requester: String, id: String): EitherT[F, SurfsUpError, Unit]

  def update(requester: String, alertId: String, updateAlertRequest: AlertRequest): EitherT[F, SurfsUpError, AlertT]
}