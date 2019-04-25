package com.rtonholo.study.instagram.data.datasource

import com.rtonholo.study.instagram.domain.Comment
import com.rtonholo.study.instagram.domain.Media
import com.rtonholo.study.instagram.domain.User

interface MediaPersistenceSource {
    fun requestMedia(fromUser: User): List<Media>
    fun add(media: Media): Boolean
    fun add(comment: Comment, media: Media): Boolean
    fun like(media: Media): Boolean
    fun like(comment: Comment): Boolean
}