package com.rtonholo.study.instagram.domain

import android.os.Parcel
import android.os.Parcelable

data class Follower(val id: String, val username: String, val fullName: String, val profilePicture: String) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(username)
        parcel.writeString(fullName)
        parcel.writeString(profilePicture)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Follower> {
        override fun createFromParcel(parcel: Parcel): Follower {
            return Follower(parcel)
        }

        override fun newArray(size: Int): Array<Follower?> {
            return arrayOfNulls(size)
        }
    }
}