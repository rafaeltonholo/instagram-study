package com.rtonholo.study.instagram.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rtonholo.study.instagram.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        nav_bottom.setOnNavigationItemSelectedListener {
//            true
//        }

        imb_user_data.setOnClickListener {
            val frag = UserDataFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frm_holder, frag, UserDataFragment.fragmentTag)
                .commit()
        }
    }
}