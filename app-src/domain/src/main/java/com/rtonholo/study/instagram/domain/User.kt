package com.rtonholo.study.instagram.domain

data class User(
    val id: String, val username: String, val fullName: String, val profilePicture: String,
    val isBusiness: Boolean, val follows: MutableList<Follower> = mutableListOf(),
    val followedBy: MutableList<Follower> = mutableListOf(), var bio: String? = null, var website: String? = null,
    var medias: MutableList<Media> = mutableListOf()
)