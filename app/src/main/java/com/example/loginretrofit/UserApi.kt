package com.example.loginretrofit

import android.provider.ContactsContract
import retrofit2.Call
import retrofit2.http.*

interface UserApi {

    @POST("user")
    fun login(
        @Body userRequest: UserRequest
    ): Call<UserResponse>

    @GET("user")
    fun Allusers(): Call<List<datausers>>

    @GET("user/")
    fun getOneEmail(@Query("email") email: String): Call<datausers>


}