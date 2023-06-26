package com.example.aplikasimeddy.room.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jadwal_user_table")
data class Jadwal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var date: Int? = null,
    var month: String? = null,
    var year: Int? = null,
    var nama_obat: String? = null,
    var gambar: String? = null,
    var waktu: String? = null,
    var waktu_minum: String? = null,
    var sisa_tablet: Int? = null,
    var anjuran_tablet: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeValue(date)
        parcel.writeString(month)
        parcel.writeValue(year)
        parcel.writeString(nama_obat)
        parcel.writeString(gambar)
        parcel.writeString(waktu)
        parcel.writeString(waktu_minum)
        parcel.writeValue(sisa_tablet)
        parcel.writeValue(anjuran_tablet)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Jadwal> {
        override fun createFromParcel(parcel: Parcel): Jadwal {
            return Jadwal(parcel)
        }

        override fun newArray(size: Int): Array<Jadwal?> {
            return arrayOfNulls(size)
        }
    }
}
