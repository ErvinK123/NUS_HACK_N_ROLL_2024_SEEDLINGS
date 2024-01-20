package com.seedlings.omnipersona

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.seedlings.omnipersona.storage.ApplicationViewModel
import com.seedlings.omnipersona.utils.VolleyUtil
import com.seedlings.omnipersona.view.fragments.CameraFragment
import com.seedlings.omnipersona.view.fragments.WelcomeFragment

class MainActivity : AppCompatActivity() {

    private val viewModel : ApplicationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        VolleyUtil.init(this, viewModel)
        initWelcomeFragment()
    }

    private fun initWelcomeFragment() {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, WelcomeFragment())
        }
    }
}
