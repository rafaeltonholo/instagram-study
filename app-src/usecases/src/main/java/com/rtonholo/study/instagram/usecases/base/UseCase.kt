package com.rtonholo.study.instagram.usecases.base

abstract class UseCase<TRequest: UseCase.RequestValues, TResponse: UseCase.ResponseValues> {

    abstract suspend operator fun invoke(param: TRequest): TResponse

    /**
     * Data passed from a request
     */
    interface RequestValues

    /**
     * Data received from a request
     */
    interface ResponseValues
}