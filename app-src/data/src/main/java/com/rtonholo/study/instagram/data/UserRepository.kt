package com.rtonholo.study.instagram.data

import com.rtonholo.study.instagram.data.datasource.UserPersistenceSource
import com.rtonholo.study.instagram.domain.Follower
import com.rtonholo.study.instagram.domain.User

class UserRepository(private val mUserPersistenceSource: UserPersistenceSource) {
    fun getUserData(id: String): User = mUserPersistenceSource.getUserData(id)
    fun getFollows(by: User): List<Follower> = mUserPersistenceSource.getFollows(by)
    fun getFollowedBy(from: User): List<Follower> = mUserPersistenceSource.getFollowedBy(from)
}