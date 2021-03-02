package com.example.loginretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {

    @SerializedName("data")
    @Expose
    var data:User? = null

    class User{
        @SerializedName("email")
        @Expose
        var email:String? = null

        @SerializedName("password")
        @Expose
        var password:String? = null
    }
}