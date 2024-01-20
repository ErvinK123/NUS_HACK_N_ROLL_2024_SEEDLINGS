package com.seedlings.omnipersona.storage

import android.app.Application
import androidx.lifecycle.AndroidViewModel


class ApplicationViewModel(application: Application) : AndroidViewModel(application) {

    private var scores: MutableList<Int> = listOf(0, 0, 0, 0, 0, 0).toMutableList()



    // Method to update the list data

}