package com.android.goally.data.model.api.response.copilot

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AudioEventX(
    val audioList: List<Audio>?,
    val event: String?
) : Parcelable