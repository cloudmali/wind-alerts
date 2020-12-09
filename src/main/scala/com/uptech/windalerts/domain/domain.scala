package com.uptech.windalerts.domain

import cats.data.EitherT
import com.uptech.windalerts.alerts.TimeRange
import com.uptech.windalerts.alerts.domain.AlertT
import com.uptech.windalerts.users.UserT


object domain {
  type SurfsUpEitherT[F[_], T] = EitherT[F, SurfsUpError, T]

  case class UserId(id: String)

  case class TokensWithUser(accessToken: String, refreshToken: String, expiredAt: Long, user: UserDTO)

  case class SubscriptionPurchase(startTimeMillis: Long,
                                  expiryTimeMillis: Long)

  final case class OTP(otp: String)


  final case class UserDTO(id: String, email: String, name: String, deviceToken: String, deviceType: String, startTrialAt: Long, endTrialAt: Long, userType: String, snoozeTill: Long, disableAllAlerts: Boolean, notificationsPerHour: Long, lastPaymentAt: Long, nextPaymentAt: Long) {
    def this(id: String, email: String, name: String, deviceToken: String, deviceType: String, startTrialAt: Long, userType: String, snoozeTill: Long, disableAllAlerts: Boolean, notificationsPerHour: Long) =
      this(id, email, name, deviceToken, deviceType, startTrialAt, if (startTrialAt == -1) -1L else (startTrialAt + (30L * 24L * 60L * 60L * 1000L)), userType, snoozeTill, disableAllAlerts, notificationsPerHour, -1, -1)

  }



  final case class AlertWithUser(alert: Alert, user: UserT)

  final case class AlertWithBeach(alert: AlertT, beach: domain.Beach)



  final case class BeachId(id: Long) extends AnyVal

  final case class Wind(direction: Double = 0, speed: Double = 0, directionText: String)

  final case class Swell(height: Double = 0, direction: Double = 0, directionText: String)

  final case class TideHeight(height: Double, status: String, nextLow: Long, nextHigh: Long)

  final case class SwellOutput(height: Double = 0, direction: Double = 0, directionText: String)

  final case class Tide(height: TideHeight, swell: SwellOutput)

  final case class Beach(beachId: BeachId, wind: Wind, tide: Tide)

  case class AlertRequest(
                           beachId: Long,
                           days: Seq[Long],
                           swellDirections: Seq[String],
                           timeRanges: Seq[TimeRange],
                           waveHeightFrom: Double,
                           waveHeightTo: Double,
                           windDirections: Seq[String],
                           tideHeightStatuses: Seq[String] = Seq("Rising", "Falling"),
                           enabled: Boolean,
                           timeZone: String = "Australia/Sydney")


  case class AlertsT(alerts: Seq[AlertT])



  case class Alert(
                    id: String,
                    owner: String,
                    beachId: Long,
                    days: Seq[Long],
                    swellDirections: Seq[String],
                    timeRanges: Seq[TimeRange],
                    waveHeightFrom: Double,
                    waveHeightTo: Double,
                    windDirections: Seq[String],
                    tideHeightStatuses: Seq[String] = Seq("Rising", "Falling"),
                    enabled: Boolean,
                    timeZone: String = "Australia/Sydney") {
  }



  case class AndroidReceiptValidationRequest(productId: String, token: String)

  case class ApplePurchaseToken(token: String)


  case class AndroidUpdate(message: Message)

  case class Message(data: String)

  case class SubscriptionNotificationWrapper(subscriptionNotification: SubscriptionNotification)

  case class SubscriptionNotification(purchaseToken: String)



  case class AppleSubscriptionPurchase(product_id: String, purchase_date_ms: Long, expires_date_ms: Long)



}