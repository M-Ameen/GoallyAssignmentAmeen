package com.android.goally

import androidx.room.TypeConverter
import com.android.goally.data.model.api.response.copilot.ActivityX
import com.android.goally.data.model.api.response.copilot.AudioEventX
import com.android.goally.data.model.api.response.copilot.LastSchedule
import com.android.goally.data.model.api.response.copilot.RoutineNotification
import com.android.goally.data.model.api.response.copilot.RoutineNotificationsV2
import com.android.goally.data.model.api.response.copilot.ScheduleV2X
import com.android.goally.data.model.api.response.copilot.ScheduleX
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoutineConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromActivityXList(value: List<ActivityX>?): String? {
        return value?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toActivityXList(value: String?): List<ActivityX>? {
        val listType = object : TypeToken<List<ActivityX>>() {}.type
        return value?.let { gson.fromJson(it, listType) }
    }

    @TypeConverter
    fun fromAudioEventXList(value: List<AudioEventX>?): String? {
        return value?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toAudioEventXList(value: String?): List<AudioEventX>? {
        val listType = object : TypeToken<List<AudioEventX>>() {}.type
        return value?.let { gson.fromJson(it, listType) }
    }

    @TypeConverter
    fun fromLastSchedule(value: LastSchedule?): String? {
        return value?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toLastSchedule(value: String?): LastSchedule? {
        return value?.let { gson.fromJson(it, LastSchedule::class.java) }
    }

    @TypeConverter
    fun fromScheduleX(value: ScheduleX?): String? {
        return value?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toScheduleX(value: String?): ScheduleX? {
        return value?.let { gson.fromJson(it, ScheduleX::class.java) }
    }

    @TypeConverter
    fun fromScheduleV2X(value: ScheduleV2X?): String? {
        return value?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toScheduleV2X(value: String?): ScheduleV2X? {
        return value?.let { gson.fromJson(it, ScheduleV2X::class.java) }
    }

    @TypeConverter
    fun fromRoutineNotificationList(value: List<RoutineNotification>?): String? {
        return value?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toRoutineNotificationList(value: String?): List<RoutineNotification>? {
        val listType = object : TypeToken<List<RoutineNotification>>() {}.type
        return value?.let { gson.fromJson(it, listType) }
    }

    @TypeConverter
    fun fromRoutineNotificationsV2List(value: List<RoutineNotificationsV2>?): String? {
        return value?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toRoutineNotificationsV2List(value: String?): List<RoutineNotificationsV2>? {
        val listType = object : TypeToken<List<RoutineNotificationsV2>>() {}.type
        return value?.let { gson.fromJson(it, listType) }
    }

    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        return value?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        val listType = object : TypeToken<List<String>>() {}.type
        return value?.let { gson.fromJson(it, listType) }
    }

    @TypeConverter
    fun fromAnyList(value: List<Any>?): String? {
        return value?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toAnyList(value: String?): List<Any>? {
        // This is less type-safe because Any can be any type. Adjust accordingly if you know the types.
        val listType = object : TypeToken<List<Any>>() {}.type
        return value?.let { gson.fromJson(it, listType) }
    }
}
