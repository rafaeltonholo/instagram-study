package com.rtonholo.study.instagram.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.rtonholo.study.instagram.R
import com.rtonholo.study.instagram.data.UserRepository
import com.rtonholo.study.instagram.domain.User
import com.rtonholo.study.instagram.framework.InMemoryUserPersistenceSource
import com.rtonholo.study.instagram.ui.presenter.UserDataPresenter
import com.rtonholo.study.instagram.usecases.RequestUserData
import kotlinx.android.synthetic.main.user_data_fragment.*

class UserDataFragment : Fragment(), UserDataPresenter.View {

    companion object {
        val fragmentTag: String = UserDataFragment::class.java.simpleName
        fun newInstance() = UserDataFragment()
    }

    private lateinit var viewModel: UserDataViewModel

    private val mPresenter: UserDataPresenter

    init {
        val persistence = InMemoryUserPersistenceSource()
        val userRepository = UserRepository(persistence)
        mPresenter = UserDataPresenter(this, RequestUserData(userRepository))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_data_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserDataViewModel::class.java)
        mPresenter.onCreate()
    }

    override fun onDestroy() {
        mPresenter.onDestroy()
        super.onDestroy()
    }

    override fun renderUserData(userData: User) {
        txt_full_name.text = userData.fullName
        txt_bio.text = userData.bio
        txt_followers.text = userData.followedBy.size.toString()
        txt_following.text = userData.follows.size.toString()
        txt_posts.text = userData.medias.size.toString()
        activity?.findViewById<TextView>(R.id.txt_title_toolbar)?.text = userData.username
    }
}
