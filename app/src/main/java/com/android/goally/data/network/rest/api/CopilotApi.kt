package com.android.goally.data.network.rest.api

import com.android.goally.data.model.api.response.copilot.Copilot
import com.kinfolk.world.data.model.api.response.culture.TokenResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CopilotApi {
    @GET("v1/api/devices/get-token")
    suspend fun getToken(@Query("name") name: String): TokenResponse

    @GET("v1/api/devices/copilot-list")
    suspend fun getCopilotList(@Header(com.android.goally.data.network.rest.Headers.TOKEN) token: String): Copilot
}
