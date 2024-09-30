package com.android.goally.data.model.api.response.copilot

data class ChecklistNotificationsV2(
    val _id: String,
    val minutesBefore: Int,
    val notificationType: String
)