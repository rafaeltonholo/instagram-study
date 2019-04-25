package com.rtonholo.study.instagram.data

import com.rtonholo.study.instagram.data.datasource.UserPersistenceSource
import com.rtonholo.study.instagram.domain.User

class UserRepository(private val mUserPersistenceSource: UserPersistenceSource) {
    fun getUserData(): User = mUserPersistenceSource.getUserData()
}