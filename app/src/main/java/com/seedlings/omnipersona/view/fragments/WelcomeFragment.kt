package com.seedlings.omnipersona.view.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.android.volley.toolbox.Volley
import com.seedlings.omnipersona.R
import com.seedlings.omnipersona.storage.ApplicationViewModel
import com.seedlings.omnipersona.utils.VolleyUtil

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private val viewModel : ApplicationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initStartTestButton()

        if (checkPermission()) {
            // Permission is already granted, perform your actions here
        } else {
            // Permission is not granted, request it
            requestPermission()
            Toast.makeText(requireContext(), R.string.no_camera_permission, Toast.LENGTH_SHORT).show()
        }

    }

    private fun isViewModelEmpty(): Boolean {
        return viewModel.getQuestion(1).isEmpty() || viewModel.getQuestion(2).isEmpty() || viewModel.getQuestion(3).isEmpty()
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
            parentFragmentManager.commit {
                replace(R.id.frameLayout, QuestionsFragment(listOf(0, 0, 0, 0, 0, 0).toMutableList(),1))
            }
        }
    }

}