package com.example.loginretrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @POST("user")
    fun login(
        @Body userRequest: UserRequest
    ): Call<UserResponse>
    @GET("user")
    fun Allusers(): Call<List<datausers>>
    @GET("/user/email")
    fun getOneEmail(): Call<List<datausers>>


}