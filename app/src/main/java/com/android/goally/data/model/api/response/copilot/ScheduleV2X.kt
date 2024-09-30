package com.android.goally.data.model.api.response.copilot

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleV2X(
    val dailyRepeatValues: DailyRepeatValues?,
    val timeType: String?,
    val timeValue: String?,
    val type: String?,
    val yearlyRepeatDateValue: String?
) : Parcelable