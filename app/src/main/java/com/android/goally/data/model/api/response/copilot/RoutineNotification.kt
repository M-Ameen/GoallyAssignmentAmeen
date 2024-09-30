package com.android.goally.data.model.api.response.copilot

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoutineNotification(
    val _id: String?,
    val audioUrl: String?,
    val isActive: Boolean?,
    val isReadText: Boolean?,
    val name: String?,
    val timeBefore: Int?
) : Parcelable