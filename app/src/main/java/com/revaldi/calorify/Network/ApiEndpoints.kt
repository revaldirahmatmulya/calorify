package com.revaldi.calorify.Network

import com.revaldi.calorify.Data.LoginUser
import com.revaldi.calorify.Data.NewUser
import com.revaldi.calorify.Data.UserData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiEndpoints {
    @POST("auth/registerdata")
    suspend fun addUserData(
        @Body request: UserData
    ): ApiResponse

    @POST("auth/login")
    suspend fun loginUser(
        @Body request: LoginUser
    ): ApiResponse

    @POST("auth/register")
    fun registerUser(
        @Body request: NewUser
    ): Call<ApiResponse>


    @GET("NewsAPI/top-headlines/category/health/in.json")
    suspend fun getHealthHeadlines(): NewsResponse
}