package com.seedlings.omnipersona.utils

import android.content.Context
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.seedlings.omnipersona.storage.ApplicationViewModel

object  VolleyUtil {
    private const val appscriptApi = "https://script.google.com/macros/s/AKfycbzI_FU_Q7oKd2Kbvt6PW5v7agzL7f3ye3BKEPKp4TO42vAhFsqgRn8V9K2MBmJslYW-/exec"

    private lateinit var queue: RequestQueue
    private lateinit var viewModel: ApplicationViewModel

    fun init(context: Context, viewModel: ApplicationViewModel) {
        queue = Volley.newRequestQueue(context)
        this.viewModel = viewModel
    }

    fun getQuestion(question:Int,
                    onSuccessListener: (String) -> Unit,
                    onErrorListener: () -> Unit) {
        val newUrl = "$appscriptApi?question=$question"
        addToStringQueue(
            Request.Method.GET,
            newUrl,
            onSuccessListener,
            onErrorListener,
            null
        )
    }

    fun getQuestionOne(onSuccessListener: (String) -> Unit,
                       onErrorListener: () -> Unit) {
        val newUrl = "$appscriptApi?question=1"
        addToStringQueue(
            Request.Method.GET,
            newUrl,
            onSuccessListener,
            onErrorListener,
            null,
        )
    }

    fun getQuestionTwo(onSuccessListener: (String) -> Unit,
                       onErrorListener: () -> Unit) {
        val newUrl = "$appscriptApi?question=2"
        addToStringQueue(
            Request.Method.GET,
            newUrl,
            onSuccessListener,
            onErrorListener,
            null,
        )
    }

    fun getQuestionThree(onSuccessListener: (String) -> Unit,
                       onErrorListener: () -> Unit) {
        val newUrl = "$appscriptApi?question=3"
        addToStringQueue(
            Request.Method.GET,
            newUrl,
            onSuccessListener,
            onErrorListener,
            null,
        )
    }

    private fun addToStringQueue(
        method: Int,
        url: String,
        onSuccessListener: (String) -> Unit,
        onErrorListener: (() -> Unit)? = null,
        body: ByteArray? = null,
    ) {
        System.out.println("addToStringQueue: sending request to $url")

        val request = object : StringRequest(method, url,
            { res ->
                System.out.println("addToStringQueue: $res")
                onSuccessListener(res)
            },
            { err ->
                System.out.println("addToStringQueue: $err")
                onErrorListener?.invoke()
            }
        ) {
        }
        request.retryPolicy = DefaultRetryPolicy()

        queue.add(request)
    }

}