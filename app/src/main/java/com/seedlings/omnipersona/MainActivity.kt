package com.seedlings.omnipersona

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.seedlings.omnipersona.view.fragments.WelcomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWelcomeFragment()
    }

    private fun initWelcomeFragment() {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, WelcomeFragment())
        }
    }
}
