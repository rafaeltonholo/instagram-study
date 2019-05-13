package com.rtonholo.study.instagram.framework

import com.rtonholo.study.instagram.data.datasource.MediaPersistenceSource
import com.rtonholo.study.instagram.domain.Comment
import com.rtonholo.study.instagram.domain.Media
import com.rtonholo.study.instagram.domain.MediaType
import com.rtonholo.study.instagram.domain.User
import kotlin.random.Random

class InMemoryMediaPersistenceSource : MediaPersistenceSource {
    override fun requestMedia(fromUser: User): List<Media> {
        if (!mediasForUser.containsKey(fromUser)) {
            mediasForUser[fromUser] = generateRandomMedia(fromUser, Random.nextInt(0, 1000))
        }

        return mediasForUser[fromUser]!!
    }

    override fun add(media: Media): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(comment: Comment, media: Media): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun like(media: Media): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun like(comment: Comment): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun generateRandomMedia(user: User, howMany: Int): List<Media> =
        (0..howMany).map {
            Media(owner = user, url = "https://picsum.photos/id/$it/2048/2048", type = MediaType.IMAGE)
        }

    companion object {
        private val mediasForUser = HashMap<User, List<Media>>()
    }
}