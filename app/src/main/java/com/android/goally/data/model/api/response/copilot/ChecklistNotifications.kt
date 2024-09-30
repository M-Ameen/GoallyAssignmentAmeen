package com.android.goally.data.model.api.response.copilot

data class ChecklistNotifications(
    val _id: String,
    val audioUrl: String,
    val isActive: Boolean,
    val isReadText: Boolean,
    val name: String,
    val timeBefore: Int
)