package com.rtonholo.study.instagram.framework

import com.rtonholo.study.instagram.data.datasource.UserPersistenceSource
import com.rtonholo.study.instagram.domain.Follower
import com.rtonholo.study.instagram.domain.User
import kotlin.random.Random

class InMemoryUserPersistenceSource : UserPersistenceSource {

    override fun getUserData(id: String): User = users.first { it.id == id }

    override fun getFollows(by: User): List<Follower> {
        follows = if (follows != null) follows
        else getFollowerObjectFromUsers(Random.nextInt(0, users.size) until users.size) {
            it.id != by.id
        }

        return follows!!
    }

    override fun getFollowedBy(from: User): List<Follower> {
        followedBy = if (followedBy != null) followedBy
        else getFollowerObjectFromUsers(Random.nextInt(0, users.size) until users.size) {
            it.id != from.id
        }

        return followedBy!!
    }

    private fun getFollowerObjectFromUsers(range: IntRange, predicate: (User) -> Boolean): List<Follower> =
        users
            .filter(predicate)
            .subList(range.first, range.last)
            .map {
                Follower(
                    id = it.id,
                    username = it.username,
                    profilePicture = it.profilePicture,
                    fullName = it.fullName
                )
            }

    companion object {
        private val users = generateUsers(1000)
        private var follows: List<Follower>? = null
        private var followedBy: List<Follower>? = null


        private fun generateUsers(howManyUsers: Int): MutableList<User> =
            (listOf(
                User(
                    id = "1",
                    username = "rafaeltonholo",
                    fullName = "Rafael Tonholo",
                    isBusiness = false,
                    profilePicture = "",
                    bio = "This is my study Instagram case.\nIt try to do the same but with some layout improvements."
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

    }
}