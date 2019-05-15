package com.rtonholo.study.instagram.ui.view.userdata.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.rtonholo.study.instagram.R
import com.rtonholo.study.instagram.domain.User
import com.rtonholo.study.instagram.ui.view.userdata.UserMediaFragment

class UserDataViewPagerAdapter(fragmentManager: FragmentManager, user: User) : FragmentStatePagerAdapter(fragmentManager) {
    private val fragments = listOf<Pair<Fragment, @androidx.annotation.DrawableRes Int>>(
        Pair(UserMediaFragment.newInstance(3, user.medias), R.drawable.ic_grid),
        Pair(UserMediaFragment.newInstance(1, user.medias), R.drawable.ic_view_day),
        Pair(UserMediaFragment.newInstance(3, user.medias), R.drawable.ic_tooltip_account)
    )

    override fun getItem(position: Int): Fragment {
        return fragments[position].first
    }

    override fun getCount(): Int = 3

    fun setupTabLayoutIcons(tabLayout: TabLayout) {
        for (i in 0..fragments.size) {
            tabLayout.getTabAt(i)?.setIcon(fragments[i].second)
        }
    }
}