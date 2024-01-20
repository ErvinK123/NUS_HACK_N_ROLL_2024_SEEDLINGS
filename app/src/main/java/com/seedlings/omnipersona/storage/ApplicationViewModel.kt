package com.seedlings.omnipersona.storage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class ApplicationViewModel(application: Application) : AndroidViewModel(application) {

    private val scores = MutableLiveData<ArrayList<Int>>()

    // Expose LiveData to the observers
    fun getScores(): MutableLiveData<ArrayList<Int>> {
        return scores
    }

    // Method to update the list data
    fun updateScores(newData: ArrayList<Int>) {
        scores.value = newData
    }

}