package com.seedlings.omnipersona.view.fragments

// import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.seedlings.omnipersona.R
import com.seedlings.omnipersona.storage.ApplicationViewModel


class QuestionsFragment(val counter: Int) : Fragment(R.layout.fragment_questions) {

    private val questionCounter = counter

    private val viewModel: ApplicationViewModel by viewModels()
    private var dataArray: List<String>? = null
    private var selectedOptionScore: String? = null // this is a 6 digit string

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // HTTP request to endpoint
        val payload: String = "Question@123456@abc@123456@def@123456@hij@123456@lmn"
        this.dataArray = payload.split("@")

        // populate texts of qn and buttons
        var questionText = requireView().findViewById<TextView>(R.id.question)
        questionText.setText(dataArray?.get(0))
        initButtonOne(dataArray)
        initButtonTwo(dataArray)
        initButtonThree(dataArray)
        initButtonFour(dataArray)
        initNextButton()
    }

    fun initButtonOne(dataArray: List<String>?) {
        var buttonOne = requireView().findViewById<Button>(R.id.option_one)
        buttonOne.setText(dataArray?.get(2))
        buttonOne.setOnClickListener {
            setButtonTextColor(buttonOne, R.color.teal_select)
            selectedOptionScore = dataArray?.get(1)
            System.out.println(selectedOptionScore)
        }
    }

    private fun setButtonTextColor(button: Button, color: Int) {
        val buttonOne = requireView().findViewById<Button>(R.id.option_one)
        val buttonTwo = requireView().findViewById<Button>(R.id.option_two)
        val buttonThree = requireView().findViewById<Button>(R.id.option_three)
        val buttonFour = requireView().findViewById<Button>(R.id.option_four)
        buttonOne.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        buttonTwo.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        buttonThree.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        buttonFour.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        button.setTextColor(ContextCompat.getColor(requireContext(), color))
    }

        fun initButtonTwo(dataArray: List<String>?) {
        var buttonTwo = requireView().findViewById<Button>(R.id.option_two)
        buttonTwo.setText(dataArray?.get(4))
        buttonTwo.setOnClickListener {
            setButtonTextColor(buttonTwo, R.color.teal_select)
            selectedOptionScore = dataArray?.get(3)
        }
    }
    fun initButtonThree(dataArray: List<String>?) {
        var buttonThree = requireView().findViewById<Button>(R.id.option_three)
        buttonThree.setText(dataArray?.get(6))
        buttonThree.setOnClickListener {
            setButtonTextColor(buttonThree, R.color.teal_select)
            selectedOptionScore = dataArray?.get(5)
        }
    }
    fun initButtonFour(dataArray: List<String>?) {
        var buttonFour = requireView().findViewById<Button>(R.id.option_four)
        buttonFour.setText(dataArray?.get(8))
        buttonFour.setOnClickListener {
            setButtonTextColor(buttonFour, R.color.teal_select)
            selectedOptionScore = dataArray?.get(7)
        }
    }

    fun initNextButton() {
        var nextButton = requireView().findViewById<Button>(R.id.next)
        nextButton.setOnClickListener {
            if (selectedOptionScore == null) {
                Toast.makeText(requireContext(), "please select an option", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val scoresToAdd = selectedOptionScore!!.toCharArray()
            for (s in scoresToAdd) {
                s.toInt()
            }
            parentFragmentManager.commit {
                if (questionCounter > 3) {
                    System.out.println("I CHANGED TO CAMERA ")
                    replace(R.id.frameLayout, CameraFragment())
                    addToBackStack(null)
                    return@commit
                }
                replace(R.id.frameLayout, QuestionsFragment(questionCounter + 1))
                addToBackStack(null)
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