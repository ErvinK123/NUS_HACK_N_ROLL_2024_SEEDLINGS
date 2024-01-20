package com.seedlings.omnipersona.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.seedlings.omnipersona.R

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initStartTestButton()
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()
    }

    fun initStartTestButton() {
        requireView().findViewById<Button>(R.id.start_button).setOnClickListener {
            // Transition to next page code

        }
    }

}