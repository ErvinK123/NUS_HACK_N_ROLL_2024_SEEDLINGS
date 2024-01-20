package com.seedlings.omnipersona

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.commit
import com.seedlings.omnipersona.storage.ApplicationViewModel
import com.seedlings.omnipersona.utils.VolleyUtil
import com.seedlings.omnipersona.view.fragments.WelcomeFragment


class MainActivity : AppCompatActivity() {

    private val viewModel : ApplicationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        VolleyUtil.init(this, viewModel)

        // Check if the permission is granted
        if (checkPermission()) {
            // Permission is already granted, perform your actions here
            initWelcomeFragment()
        } else {
            // Permission is not granted, request it
            requestPermission()
        }

        initWelcomeFragment()
    }

    private fun checkPermission(): Boolean {
        // Check if the permission is granted
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        // Request the CAMERA permission
        ActivityCompat.requestPermissions(
            this,
            arrayOf<String>(Manifest.permission.CAMERA),
            101
        )
    }

    private fun initWelcomeFragment() {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, WelcomeFragment())
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // Check if the request code matches the one you used to request the CAMERA permission
        if (requestCode == 101) {
            // Check if the CAMERA permission is granted
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, perform your actions here
                initWelcomeFragment()
            } else {
                // Permission denied, handle it accordingly (show a message, disable functionality, etc.)
                requestPermission()
            }
        }
    }
}
