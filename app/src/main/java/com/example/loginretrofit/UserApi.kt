package com.example.loginretrofit

import android.provider.ContactsContract
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserApi {

    @POST("user")
    fun login(
        @Body userRequest: UserRequest
    ): Call<UserResponse>

    @GET("user")
    fun Allusers(): Call<List<datausers>>

    @GET("user/{email}")
    fun getOneEmail(@Path("email") email: String): Call<ResponseBody>


}