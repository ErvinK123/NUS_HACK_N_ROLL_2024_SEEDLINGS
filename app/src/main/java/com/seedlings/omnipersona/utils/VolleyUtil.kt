package com.seedlings.omnipersona.utils

import android.content.Context
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.seedlings.omnipersona.storage.ApplicationViewModel

object VolleyUtil {
    private const val appscriptApi = ""

    private lateinit var queue: RequestQueue
    private lateinit var viewModel: ApplicationViewModel

    fun init(context: Context, viewModel: ApplicationViewModel) {
        queue = Volley.newRequestQueue(context)
        this.viewModel = viewModel
    }

    fun getQuestionOne(onSuccessListener: () -> Unit,
                       onErrorListener: () -> Unit) {

    }

    fun getQuestionTwo(onSuccessListener: () -> Unit,
                       onErrorListener: () -> Unit) {

    }

    fun getQuestionThree(onSuccessListener: () -> Unit,
                       onErrorListener: () -> Unit) {

    }

}