package com.android.goally.data.model.api.response.copilot

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DailyRepeatValues(
    val Fri: List<String>?,
    val Mon: List<String>?,
    val Sat: List<String>?,
    val Sun: List<String>?,
    val Thu: List<String>?,
    val Tue: List<String>?,
    val Wed: List<String?>
) : Parcelable