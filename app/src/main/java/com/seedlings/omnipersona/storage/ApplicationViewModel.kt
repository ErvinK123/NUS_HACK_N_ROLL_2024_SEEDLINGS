package com.seedlings.omnipersona.storage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class ApplicationViewModel(application: Application) : AndroidViewModel(application) {
    var questionOnePayload = ""
    var questionTwoPayload = ""
    var questionThreePayload = ""

    private var scores: List<Int> = ArrayList<Int>()

    // Method to update the list data
    fun updateScores(scoresToAdd: List<Int>) {
        var i = 0
        scores.toMutableList().apply {
            this[0] = scores[0] + scoresToAdd[i++]
        }
    }

    fun getQuestion(question:Int): String {
        if (question == 1) {
            return questionOnePayload
        }
        if (question == 2) {
            return questionTwoPayload
        }
        if (question == 3) {
            return questionThreePayload
        }
        return "hello"
    }

}