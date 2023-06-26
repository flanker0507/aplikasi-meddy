package com.example.aplikasimeddy.model_responses

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ArtikelResponse(

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null,

	@field:SerializedName("userId")
	val userId: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(judul)
		parcel.writeString(title)
		parcel.writeString(tanggal)
		parcel.writeString(uuid)
		parcel.writeString(gambar)
		parcel.writeString(userId)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ArtikelResponse> {
		override fun createFromParcel(parcel: Parcel): ArtikelResponse {
			return ArtikelResponse(parcel)
		}

		override fun newArray(size: Int): Array<ArtikelResponse?> {
			return arrayOfNulls(size)
		}
	}
}


