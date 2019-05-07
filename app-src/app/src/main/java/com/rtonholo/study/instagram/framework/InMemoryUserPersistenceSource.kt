package com.rtonholo.study.instagram.framework

import com.rtonholo.study.instagram.data.datasource.UserPersistenceSource
import com.rtonholo.study.instagram.domain.Follower
import com.rtonholo.study.instagram.domain.User
import kotlin.random.Random

class InMemoryUserPersistenceSource : UserPersistenceSource {

    private val mUsers = generateUsers(1000)
    private var mFollows: List<Follower>? = null
    private var mFolloweedBy: List<Follower>? = null

    override fun getUserData(id: String): User = mUsers.first { it.id == id }

    override fun getFollows(by: User): List<Follower> {
        mFollows = if (mFollows != null) mFollows
        else getFollowerObjectFromUsers(Random.nextInt(0, mUsers.size) until mUsers.size) {
            it.id != by.id
        }

        return mFollows!!
    }

    override fun getFollowedBy(from: User): List<Follower> {
        mFolloweedBy = if (mFolloweedBy != null) mFolloweedBy
        else getFollowerObjectFromUsers(Random.nextInt(0, mUsers.size) until mUsers.size) {
            it.id != from.id
        }

        return mFolloweedBy!!
    }

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

    private fun getFollowerObjectFromUsers(range: IntRange, predicate: (User) -> Boolean): List<Follower> =
        mUsers
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
}