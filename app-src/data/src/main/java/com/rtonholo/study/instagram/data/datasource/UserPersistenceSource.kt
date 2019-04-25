package com.rtonholo.study.instagram.data.datasource

import com.rtonholo.study.instagram.domain.User

interface UserPersistenceSource {
    fun getUserData(): User
}