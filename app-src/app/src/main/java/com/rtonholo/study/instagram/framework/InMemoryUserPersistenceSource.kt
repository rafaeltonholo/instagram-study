package com.rtonholo.study.instagram.framework

import com.rtonholo.study.instagram.data.datasource.UserPersistenceSource
import com.rtonholo.study.instagram.domain.Follower
import com.rtonholo.study.instagram.domain.User
import kotlin.random.Random

class InMemoryUserPersistenceSource : UserPersistenceSource {

    private val mUsers = generateUsers(1000)

    override fun getUserData(id: String): User = mUsers.first { it.id == id }

    override fun getFollows(by: User): List<Follower> =
        getFollowerObjectFromUsers(Random.nextInt()..mUsers.size) {
            it.id != by.id
        }

    override fun getFollowedBy(from: User): List<Follower> =
        getFollowerObjectFromUsers(Random.nextInt()..mUsers.size) {
            it.id != from.id
        }

    private fun generateUsers(howManyUsers: Int): MutableList<User> =
        (listOf(
            User(
                id = "1",
                username = "rafaeltonholo",
                fullName = "Rafael Tonholo",
                isBusiness = false,
                profilePicture = ""
            )
        ) + (2..howManyUsers).map {
            User(
                id = "$it",
                username = "testing$it",
                fullName = "Testing User $it",
                isBusiness = false,
                profilePicture = ""
            )
        }).toMutableList()

    private fun getFollowerObjectFromUsers(range: IntRange, predicate: (User) -> Boolean): List<Follower> =
        mUsers
            .filter(predicate)
            .subList(range.first, range.last)
            .map { Follower(id = it.id, username = it.username, profilePicture = it.profilePicture, fullName = it.fullName) }
}