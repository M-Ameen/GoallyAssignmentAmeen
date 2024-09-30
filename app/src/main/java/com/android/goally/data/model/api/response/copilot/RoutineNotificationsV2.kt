package com.android.goally.data.model.api.response.copilot

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoutineNotificationsV2(
    val _id: String?,
    val minutesBefore: Int?,
    val notificationType: String?,
    val scheduledTime: String?
) : Parcelable