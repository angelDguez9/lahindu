package com.example.loginretrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @POST("login")
    fun login(
        @Body userRequest: UserRequest
    ): Call<UserResponse>
}