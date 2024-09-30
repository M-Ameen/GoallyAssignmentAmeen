package com.android.goally.data.model.api.response.copilot

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleX(
    val Fri: String?,
    val Mon: String?,
    val Sat: String?,
    val Sun: String?,
    val Thu: String?,
    val Tue: String?,
    val Wed: String?
) : Parcelable