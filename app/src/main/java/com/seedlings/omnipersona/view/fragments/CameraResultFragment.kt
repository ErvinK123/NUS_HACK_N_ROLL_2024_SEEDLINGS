package com.seedlings.omnipersona.view.fragments

import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.seedlings.omnipersona.R

class CameraResultFragment(private val bitmap: Bitmap): Fragment(R.layout.fragment_camera_result){

    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireView().findViewById<ImageView>(R.id.testImage)
        imageView.setImageBitmap(bitmap)

        requireView().findViewById<Button>(R.id.photoNext).setOnClickListener {
            parentFragmentManager.commit{
                replace(R.id.frameLayout, ResultFragment())
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
}