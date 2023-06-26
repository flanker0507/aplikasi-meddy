package com.example.aplikasimeddy.model_responses

import android.os.Parcel
import android.os.Parcelable
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

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("efek")
	val efek: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(komposisi)
		parcel.writeString(kegunaan)
		parcel.writeString(name)
		parcel.writeString(jenis)
		parcel.writeString(deskripsi)
		parcel.writeString(efek)
		parcel.writeString(uuid)
		parcel.writeString(gambar)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ObatResponse> {
		override fun createFromParcel(parcel: Parcel): ObatResponse {
			return ObatResponse(parcel)
		}

		override fun newArray(size: Int): Array<ObatResponse?> {
			return arrayOfNulls(size)
		}
	}
}

