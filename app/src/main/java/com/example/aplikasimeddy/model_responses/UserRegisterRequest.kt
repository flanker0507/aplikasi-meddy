package com.example.aplikasimeddy.model_responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserRegisterRequest(
    @SerializedName("password")
    @Expose
    var password: String? = null,

    @SerializedName("role")
    @Expose
    var role: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("id")
    @Expose
    var id: Long? = null,

    @SerializedName("confPassword")
    @Expose
    var confPassword: String? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null
)
