package com.seedlings.omnipersona.storage

import android.app.Application
import androidx.lifecycle.AndroidViewModel


class ApplicationViewModel(application: Application) : AndroidViewModel(application) {
    var questionOnePayload = ""
    var questionTwoPayload = ""
    var questionThreePayload = ""

    private var scores: MutableList<Int> = listOf(0, 0, 0, 0, 0, 0).toMutableList()



    // Method to update the list data

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