package com.rtonholo.study.instagram.domain

import android.os.Parcel
import android.os.Parcelable

data class Media(
    val owner: User, val url: String, val type: MediaType, var likes: Int = 0,
    var viewers: Int? = null, var comments: List<Comment>? = null, var tagged: List<User>? = null,
    var location: Location? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        owner = parcel.readParcelable(User::class.java.classLoader)!!,
        url = parcel.readString()!!,
        type = MediaType.values()[parcel.readInt()],
        likes = parcel.readInt(),
        viewers = parcel.readValue(Int::class.java.classLoader) as? Int,
        comments = parcel.createTypedArrayList(Comment),
        tagged = parcel.createTypedArrayList(User),
        location = parcel.readParcelable(Location::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(owner, flags)
        parcel.writeString(url)
        parcel.writeInt(type.ordinal)
        parcel.writeInt(likes)
        parcel.writeValue(viewers)
        parcel.writeTypedList(comments)
        parcel.writeTypedList(tagged)
        parcel.writeParcelable(location, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Media> {
        override fun createFromParcel(parcel: Parcel): Media {
            return Media(parcel)
        }

        override fun newArray(size: Int): Array<Media?> {
            return arrayOfNulls(size)
        }
    }

}

enum class MediaType {
    IMAGE, MOVIE
}