package com.android.goally.data.model.api.response.copilot

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class LastSchedule(
    val Fri: @RawValue Any?,
    val Mon: @RawValue Any?,
    val Sat: @RawValue Any?,
    val Sun: @RawValue Any?,
    val Thu: @RawValue Any?,
    val Tue: @RawValue Any?,
    val Wed: @RawValue Any?
) : Parcelable
