package com.rtonholo.study.instagram.domain

data class Media(
    val owner: User, val url: String, val type: MediaType, var likes: Int = 0,
    var viewers: Int? = null, var comments: List<Comment>? = null, var tagged: List<User>? = null,
    var location: Location
)

enum class MediaType {
    IMAGE, MOVIE
}