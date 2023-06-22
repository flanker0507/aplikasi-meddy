package com.example.aplikasimeddy.model_responses

import com.google.gson.annotations.SerializedName

data class ObatResponse(

	@field:SerializedName("komposisi")
	val komposisi: String? = null,

	@field:SerializedName("kegunaan")
	val kegunaan: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("jenis")
	val jenis: String? = null,

	@field:SerializedName("efek")
	val efek: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null
)
