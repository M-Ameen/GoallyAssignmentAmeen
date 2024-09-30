package com.android.goally.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.goally.data.model.api.response.copilot.Routine
/*
@Dao
interface RoutineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoutine(routine: Routine)

    @Query("DELETE FROM routine_table")
    suspend fun clearAllRoutines()
}*/
