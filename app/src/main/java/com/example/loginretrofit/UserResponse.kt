package com.example.loginretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse: ArrayList<datausers> ()

        data class datausers(
                @SerializedName("email")
                @Expose
                var email:String? = null,

                @SerializedName("password")
                @Expose
                var password:String? = null
)


