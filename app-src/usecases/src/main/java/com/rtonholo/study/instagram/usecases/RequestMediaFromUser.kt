package com.rtonholo.study.instagram.usecases

import com.rtonholo.study.instagram.data.MediaRepository
import com.rtonholo.study.instagram.domain.Media
import com.rtonholo.study.instagram.domain.User
import com.rtonholo.study.instagram.usecases.base.UseCase

class RequestMediaFromUser(private val mMediaRepository: MediaRepository) :
    UseCase<RequestMediaFromUser.RequestValues, RequestMediaFromUser.ResponseValues>() {
    override suspend operator fun invoke(param: RequestValues): ResponseValues =
        ResponseValues(mMediaRepository.requestMedia(fromUser = param.user))

    data class RequestValues(val user: User) : UseCase.RequestValues
    data class ResponseValues(val medias: List<Media>) : UseCase.ResponseValues
}
