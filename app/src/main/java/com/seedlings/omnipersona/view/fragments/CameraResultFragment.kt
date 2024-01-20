package com.seedlings.omnipersona.view.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.color.utilities.Score
import com.seedlings.omnipersona.R

class CameraResultFragment(private val curScore: MutableList<Int>, private val bitmap: Bitmap, private val picList: List<String>): Fragment(R.layout.fragment_camera_result){

    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = requireView().findViewById<ImageView>(R.id.testImage)
        imageView.setImageBitmap(bitmap)
        classifyItem(picList)

        requireView().findViewById<Button>(R.id.photoNext).setOnClickListener {
            parentFragmentManager.commit{
                replace(R.id.frameLayout, ResultFragment(curScore))
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    private fun classifyItem(picList: List<String>) {
        val personalities = mapOf(
            0 to listOf(
                "Bonfire", "Tractor", "Aquarium", "Circus", "Infrastructure", "Ferris wheel",
                "Comet", "Mortarboard", "Track", "Christmas", "Rocket", "Rein", "Skiing", "Submarine"
            ),
            1 to listOf(
                "Park", "Graduation", "Bridge", "Sitting", "Cushion", "Sunset", "Prom", "Reef",
                "Picnic", "Wreath", "Ballroom", "Feather", "Swan", "Dove", "Squirrel"
            ),
            2 to listOf(
                "Tights", "Bird", "Factory", "Twig", "Petal", "Sunglasses", "Watercolor paint",
                "Competition", "Cliff", "Badminton", "Stadium", "Bus", "Sky", "Gerbil", "Menu",
                "Cabinetry", "Laptop", "Robot", "Calculator", "Scale", "Microscope"
            ),
            3 to listOf(
                "Bear", "Eating", "Tower", "Brick", "Junk", "Person", "Windsurfing", "Swimwear",
                "Roller", "Camping", "Playground", "Laugh", "Balloon", "Concert", "Dance", "Safari"
            ),
            4 to listOf(
                "Boat", "Bicycle", "Stadium", "Bullfighting", "Rock", "Interaction", "Dress", "Shorts",
                "Surfboard", "Fast food", "Hot dog", "Sports car", "Tennis", "Running", "Basketball",
                "Soccer", "Rugby", "Swimming", "Rowing", "Skateboarding", "Snowboarding", "Waterskiing"
            ),
            5 to listOf(
                "Laugh", "Balloon", "Concert", "Prom", "Construction", "Product", "Reef", "Picnic",
                "Wreath", "Wheelbarrow", "Book", "Glasses", "Telescope", "Violin", "Candle", "Castle",
                "Church", "Clock", "Globe", "Sculpture", "Thinker", "Old man", "Grandparent"
            )
        )

        for (item in picList) {
            for ((personality, labels) in personalities) {
                println(item)
                if (labels.contains(item)) {
                    curScore[personality] += 1
                }
            }
        }
    }

}