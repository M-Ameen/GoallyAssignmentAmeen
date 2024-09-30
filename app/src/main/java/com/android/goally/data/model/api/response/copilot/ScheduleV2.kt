package com.android.goally.data.model.api.response.copilot

data class ScheduleV2(
    val dailyRepeatValues: DailyRepeatValues,
    val timeType: String,
    val type: String
)