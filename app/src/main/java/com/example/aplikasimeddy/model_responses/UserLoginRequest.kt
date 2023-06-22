package com.example.aplikasimeddy.model_responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserLoginRequest(
    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("password")
    @Expose
    var password: String? = null,
)
