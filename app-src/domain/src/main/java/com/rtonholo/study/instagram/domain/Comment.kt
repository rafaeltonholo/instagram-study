package com.rtonholo.study.instagram.domain

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Comment(val text: String, val owner: User, val likes: Int, val time: Date) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readParcelable(User::class.java.classLoader)!!,
        parcel.readInt(),
        Date(parcel.readLong())
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(text)
        parcel.writeParcelable(owner, flags)
        parcel.writeInt(likes)
        parcel.writeLong(time.time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comment> {
        override fun createFromParcel(parcel: Parcel): Comment {
            return Comment(parcel)
        }

        override fun newArray(size: Int): Array<Comment?> {
            return arrayOfNulls(size)
        }
    }
}