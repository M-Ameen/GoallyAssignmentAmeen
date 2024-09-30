package com.android.goally.data.model.api.response.copilot

data class Copilot(
    val routines: List<Routine> = emptyList(),
    val checklists: List<Checklists> = emptyList()
)