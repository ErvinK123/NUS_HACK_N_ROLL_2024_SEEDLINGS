package com.seedlings.omnipersona.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.seedlings.omnipersona.R

class ResultFragment : Fragment(R.layout.fragment_result) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()
    }

    fun initRetakeButton() {
        requireView().findViewById<Button>(R.id.retake).setOnClickListener {
            // Transition to next page code
            System.out.println("I am retaking the quiz")
            parentFragmentManager.commit {
                replace(R.id.frameLayout, WelcomeFragment())
                addToBackStack(null)
            }
        }
    }

}