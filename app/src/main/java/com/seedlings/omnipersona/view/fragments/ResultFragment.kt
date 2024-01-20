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
        val images = arrayOf("trailblazer.jpg", "peacemaker.jpg", "analyst.jpg", "freespirit.jpg", "athlete.jpg", "sage.jpg")
        val maxIndex = curScore.indexOf(curScore.maxOrNull())
        val personality = table[maxIndex]
        val image = images[maxIndex]
        requireView().findViewById<TextView>(R.id.result).setText(personality)
        val imageView = requireView().findViewById<ImageView>(R.id.resultImage)
        val bitmap = BitmapFactory.decodeFile("app/src/main/res/drawable/trailblazer.jpg")
        imageView.setImageBitmap(bitmap)
        println(table[maxIndex])
        return table[maxIndex]
    }

}