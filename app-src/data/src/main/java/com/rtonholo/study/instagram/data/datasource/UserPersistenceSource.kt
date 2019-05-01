package com.rtonholo.study.instagram.data.datasource

import com.rtonholo.study.instagram.domain.Follower
import com.rtonholo.study.instagram.domain.User

interface UserPersistenceSource {
    fun getUserData(id: String): User
    fun getFollows(by: User): List<Follower>
    fun getFollowedBy(from: User): List<Follower>
}