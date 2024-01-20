package com.seedlings.omnipersona.view.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.seedlings.omnipersona.R

class ResultFragment(private val curScore: MutableList<Int>) : Fragment(R.layout.fragment_result) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getResult()
        initRetakeButton()
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()
    }

    fun initRetakeButton() {
        requireView().findViewById<Button>(R.id.retakeButton).setOnClickListener {
            // Transition to next page code
            System.out.println("I am retaking the quiz")
            parentFragmentManager.commit {
                replace(R.id.frameLayout, WelcomeFragment())
            }
        }
    }

    fun getResult(): String {
        val table = arrayOf("The Trailblazer", "The Peacemaker", "The Analyst", "The Free Spirit", "The Athlete", "The Sage")
        val images = arrayOf(R.drawable.trailblazer, R.drawable.peacemaker, R.drawable.analyst, R.drawable.freespirit, R.drawable.athlete, R.drawable.sage)
        val descriptions = arrayOf(
            R.string.trailbreaker_desc,
            R.string.peacemaker_desc,
            R.string.analyst_desc,
            R.string.free_spirit_desc,
            R.string.athlete_desc,
            R.string.sage_desc
        )
        val maxIndex = curScore.indexOf(curScore.maxOrNull())
        val personality = table[maxIndex]
        val image = images[maxIndex]
        val description = descriptions[maxIndex]
        requireView().findViewById<TextView>(R.id.result).setText(personality)
        requireView().findViewById<TextView>(R.id.description).setText(description)
        val imageView = requireView().findViewById<ImageView>(R.id.resultImage)
        imageView.setImageResource(image)
        println(table[maxIndex])
        return table[maxIndex]
    }

}