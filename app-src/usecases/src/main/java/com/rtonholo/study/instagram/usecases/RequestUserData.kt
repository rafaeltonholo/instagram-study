package com.rtonholo.study.instagram.usecases

import com.rtonholo.study.instagram.data.UserRepository
import com.rtonholo.study.instagram.domain.User
import com.rtonholo.study.instagram.usecases.base.UseCase

class RequestUserData(private val mUserRepository: UserRepository) :
    UseCase<RequestUserData.RequestValues, RequestUserData.ResponseValues>() {
    override suspend fun invoke(param: RequestValues): ResponseValues {
        val user = mUserRepository.getUserData(param.id)

        val followedBy = mUserRepository.getFollowedBy(from = user)
        val follows = mUserRepository.getFollows(by = user)
        user.followedBy += followedBy
        user.follows += follows

        return ResponseValues(user)
    }

    data class RequestValues(val id: String) : UseCase.RequestValues
    data class ResponseValues(val user: User) : UseCase.ResponseValues
}