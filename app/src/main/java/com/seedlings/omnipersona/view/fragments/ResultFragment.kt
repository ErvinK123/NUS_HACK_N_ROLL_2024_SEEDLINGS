package com.seedlings.omnipersona.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.color.utilities.Score
import com.seedlings.omnipersona.R

class ResultFragment(private val curScore: MutableList<Int>) : Fragment(R.layout.fragment_result) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRetakeButton()
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
            }
        }
    }

    fun getResult(): String {
        val table = arrayOf("The Trailblazer", "The Peacemaker", "The Analyst", "The Free Spirit", "The Athlete", "The Sage")
        val maxIndex = curScore.indexOf(curScore.maxOrNull())
        return table[maxIndex]
    }

}