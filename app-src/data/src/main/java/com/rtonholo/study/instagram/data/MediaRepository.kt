package com.rtonholo.study.instagram.data

import com.rtonholo.study.instagram.data.datasource.MediaPersistenceSource
import com.rtonholo.study.instagram.domain.Comment
import com.rtonholo.study.instagram.domain.Media
import com.rtonholo.study.instagram.domain.User

class MediaRepository(private val mMediaPersistenceSource: MediaPersistenceSource) {
    fun requestMedia(fromUser: User): List<Media> = mMediaPersistenceSource.requestMedia(fromUser)
    fun add(media: Media): Boolean = mMediaPersistenceSource.add(media)
    fun add(comment: Comment, media: Media): Boolean = mMediaPersistenceSource.add(comment, media)
    fun like(media: Media): Boolean = mMediaPersistenceSource.like(media)
    fun like(comment: Comment): Boolean = mMediaPersistenceSource.like(comment)
}