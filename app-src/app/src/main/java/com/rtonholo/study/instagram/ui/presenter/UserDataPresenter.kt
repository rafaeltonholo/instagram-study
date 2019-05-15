package com.rtonholo.study.instagram.ui.presenter

import com.rtonholo.study.instagram.domain.User
import com.rtonholo.study.instagram.ui.presenter.base.Presenter
import com.rtonholo.study.instagram.usecases.RequestMediaFromUser
import com.rtonholo.study.instagram.usecases.RequestUserData
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UserDataPresenter(
    private var mView: View?,
    private val mRequestUserData: RequestUserData,
    private val mRequestMediaFromUser: RequestMediaFromUser
) : Presenter, CoroutineScope {
    private lateinit var mJob: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + mJob

    override fun onCreate() {
        mJob = Job()
        launch {
            val userId = "1"
            val userDataParams = RequestUserData.RequestValues(userId)
            val userData = mRequestUserData(userDataParams)

            val userMediaParams = RequestMediaFromUser.RequestValues(user = User(id = userId))
            val userMedia = mRequestMediaFromUser(userMediaParams)
            val user = userData.user
            user.medias.addAll(userMedia.medias)
            withContext(Dispatchers.Main) { mView?.renderUserData(userData = userData.user) }
        }

    }

    override fun onDestroy() {
        mView = null
        mJob.cancel()
    }

    interface View {
        fun renderUserData(userData: User)
    }
}