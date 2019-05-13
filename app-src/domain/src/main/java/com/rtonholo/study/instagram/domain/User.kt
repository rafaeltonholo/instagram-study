package com.rtonholo.study.instagram.domain

import android.os.Parcel
import android.os.Parcelable

data class User(
    val id: String, val username: String, val fullName: String, val profilePicture: String,
    val isBusiness: Boolean, val follows: MutableList<Follower> = mutableListOf(),
    val followedBy: MutableList<Follower> = mutableListOf(), var bio: String? = null, var website: String? = null,
    var medias: MutableList<Media> = mutableListOf()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readString()!!,
        username = parcel.readString()!!,
        fullName = parcel.readString()!!,
        profilePicture = parcel.readString()!!,
        isBusiness = parcel.readByte() != 0.toByte(),
        follows = parcel.createTypedArrayList(Follower)!!,
        followedBy = parcel.createTypedArrayList(Follower)!!,
        bio = parcel.readString(),
        website = parcel.readString(),
        medias = parcel.createTypedArrayList(Media)!!
    )

    constructor(id: String) : this(id, username = "", fullName = "", profilePicture = "", isBusiness = false)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(username)
        parcel.writeString(fullName)
        parcel.writeString(profilePicture)
        parcel.writeByte(if (isBusiness) 1 else 0)
        parcel.writeTypedList(follows)
        parcel.writeTypedList(followedBy)
        parcel.writeString(bio)
        parcel.writeString(website)
        parcel.writeTypedList(medias)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}