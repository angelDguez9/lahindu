package com.example.loginretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {
    @SerializedName("id")
    @Expose
    var email:String? = null

    @SerializedName("city")
    @Expose
    var password:String? = null
}