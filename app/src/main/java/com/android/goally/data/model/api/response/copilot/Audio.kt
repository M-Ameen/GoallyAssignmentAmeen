package com.android.goally.data.model.api.response.copilot

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Audio(
    val isSelected: Boolean?,
    val name: String?,
    val ordering: Int?,
    val paUrl: String?,
    val url: String?
) : Parcelable