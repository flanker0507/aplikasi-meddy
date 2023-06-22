package com.example.aplikasimeddy.model_responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class UserLoginResponse(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
