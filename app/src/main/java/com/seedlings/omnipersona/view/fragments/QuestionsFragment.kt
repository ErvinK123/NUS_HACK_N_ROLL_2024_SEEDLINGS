package com.seedlings.omnipersona.view.fragments

// import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.seedlings.omnipersona.R
import com.seedlings.omnipersona.storage.ApplicationViewModel


class QuestionsFragment(private val counter: Int) : Fragment(R.layout.fragment_questions) {

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
        val payload: String = "Question@123456@Option1@123456@Option2@123456@Option3@123456@Option4"
        this.dataArray = payload.split("@")

        // populate texts of qn and buttons

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
        selectedOptionScore = dataArray?.get(1)
        }
    }
    fun initButtonTwo(dataArray: List<String>?) {
        var buttonTwo = requireView().findViewById<Button>(R.id.option_two)
        buttonTwo.setText(dataArray?.get(4))
        buttonTwo.setOnClickListener {
            selectedOptionScore = dataArray?.get(3)
        }
    }
    fun initButtonThree(dataArray: List<String>?) {
        var buttonThree = requireView().findViewById<Button>(R.id.option_three)
        buttonThree.setText(dataArray?.get(6))
        buttonThree.setOnClickListener {
            selectedOptionScore = dataArray?.get(5)
        }
    }
    fun initButtonFour(dataArray: List<String>?) {
        var buttonFour = requireView().findViewById<Button>(R.id.option_four)
        buttonFour.setText(dataArray?.get(8))
        buttonFour.setOnClickListener {
            selectedOptionScore = dataArray?.get(7)
        }
    }

    fun initNextButton() {
//        if (selectedOptionScore == null) {
//            Toast.makeText(requireContext(), "please select an option", Toast.LENGTH_SHORT).show()
//        }
//        val scoresToAdd = selectedOptionScore!!.toCharArray()
//        for (s in scoresToAdd) {
//            s.toInt()
//        }
        parentFragmentManager.commit {
            replace(R.id.frameLayout, QuestionsFragment(counter + 1))
            addToBackStack(null)
        }
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()
    }

}