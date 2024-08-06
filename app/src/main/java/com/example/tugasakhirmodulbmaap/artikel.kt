package com.example.tugasakhirmodulbmaap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class artikel(
    val nama:String,
    val desc:String,
    val photo:Int,
    val tanggalRilis:String,
    val isi:String
):Parcelable
