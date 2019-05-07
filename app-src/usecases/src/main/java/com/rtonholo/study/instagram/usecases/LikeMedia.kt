package com.rtonholo.study.instagram.usecases

import com.rtonholo.study.instagram.data.MediaRepository
import com.rtonholo.study.instagram.domain.Media
import com.rtonholo.study.instagram.usecases.base.UseCase

class LikeMedia(private val mMediaRepository: MediaRepository) : UseCase<LikeMedia.RequestValues, LikeMedia.ResponseValues>() {
    override suspend fun invoke(param: RequestValues): ResponseValues =
        ResponseValues(mMediaRepository.like(param.media))

    data class RequestValues(val media: Media) : UseCase.RequestValues
    data class ResponseValues(val success: Boolean) : UseCase.ResponseValues
}