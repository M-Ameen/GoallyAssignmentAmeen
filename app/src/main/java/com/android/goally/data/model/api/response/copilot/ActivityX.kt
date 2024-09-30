package com.android.goally.data.model.api.response.copilot

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActivityX(
    val _id: String?,
    val allowBack: Boolean?,
    val allowCancelActivity: Boolean?,
    val allowPauseActivity: Boolean?,
    val allowPush: Boolean?,
    val allowRestart: Boolean?,
    val audioType: String?,
    val audioUrl: String?,
    val autoComplete: Boolean?,
    val createdAt: String?,
    val createdBy: String?,
    val imgURL: String?,
    val libraryType: String?,
    val maxCompletionTime: Double?,
    val migrated: Boolean?,
    val minCompletionTime: Int?,
    val name: String?,
    val numOfAudioRepeats: Int?,
    val openAIMp3Text: String?,
    val openAIMp3Url: String?,
    val ordering: Int?,
    val parentActivityId: String?,
    val showTimer: Boolean?,
    val updatedAt: String?
) : Parcelable
