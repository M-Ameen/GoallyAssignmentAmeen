package com.android.goally.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import com.android.goally.data.model.api.response.copilot.Copilot
import com.android.goally.data.model.api.response.copilot.Routine
import com.android.goally.data.network.rest.api.CopilotApi
import com.kinfolk.world.data.model.api.response.culture.TokenResponse

class CopilotRepository(
    private val copilotApi: CopilotApi,
) {


    suspend fun fetchToken(name:String): TokenResponse {
        val tokenResponse = copilotApi.getToken(name)
        return tokenResponse
    }

     suspend fun fetchCopilots(token: String): Copilot {
        Log.d("CopilotRepository", "fetchCopilots: $token")
        val copilot = copilotApi.getCopilotList("$token")

        val routines = copilot.routines

//        saveRoutinesToDatabase(routines) room work not completed
        return copilot

    }

    /*private suspend fun saveRoutinesToDatabase(routines: List<Routine>) {
        Log.d("CopilotRepository", "saveRoutinesToDatabase: ${routines.size}")
        routines.forEach { routine ->
            Log.d("CopilotRepository", "saveRoutinesToDatabase: ${routine.toString()}")
            routineDao.insertRoutine(routine)
        }
    }*/

}
