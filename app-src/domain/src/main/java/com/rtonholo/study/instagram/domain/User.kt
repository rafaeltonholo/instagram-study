package com.rtonholo.study.instagram.domain

data class User(val id: String, val username: String, val fullName: String, val profilePicture: String, val bio: String,
                val website: String, val isBusiness: Boolean, val counts: Counts)