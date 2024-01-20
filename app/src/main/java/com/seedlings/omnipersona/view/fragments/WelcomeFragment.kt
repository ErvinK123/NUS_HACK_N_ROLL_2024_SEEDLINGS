package com.seedlings.omnipersona.view.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.seedlings.omnipersona.R

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (checkPermission()) {
            // Permission is already granted, perform your actions here
            initStartTestButton()
        } else {
            // Permission is not granted, request it
            requestPermission()
            Toast.makeText(requireContext(), R.string.no_camera_permission, Toast.LENGTH_SHORT).show()
        }

    }

    private fun checkPermission(): Boolean {
        // Check if the permission is granted
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        // Request the CAMERA permission
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf<String>(Manifest.permission.CAMERA),
            101
        )
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()
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
            } else {
                // Permission denied, handle it accordingly (show a message, disable functionality, etc.)
                requestPermission()
            }
        }
    }

    fun initStartTestButton() {
        requireView().findViewById<Button>(R.id.start_button).setOnClickListener {
            // Transition to next page code
            System.out.println("I PRESSED START TEST")
            parentFragmentManager.commit {
                replace(R.id.frameLayout, QuestionsFragment(listOf(0, 0, 0, 0, 0, 0).toMutableList(),1))
                addToBackStack(null)
            }
        }
    }

}