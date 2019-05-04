package com.rtonholo.study.instagram.ui.presenter

import com.rtonholo.study.instagram.domain.User
import com.rtonholo.study.instagram.ui.presenter.base.Presenter
import com.rtonholo.study.instagram.usecases.RequestUserData
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UserDataPresenter(
    private var mView: View?,
    private val mRequestUserData: RequestUserData
) : Presenter, CoroutineScope {
    private lateinit var mJob: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + mJob

    override fun onCreate() {
        mJob = Job()
        launch {
            val userId = "1"
            val requestValues = RequestUserData.RequestValues(userId)
            val userData = mRequestUserData(requestValues)
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