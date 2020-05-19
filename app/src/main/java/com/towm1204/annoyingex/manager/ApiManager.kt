package com.towm1204.annoyingex.manager

import com.towm1204.annoyingex.ExMessagesService
import com.towm1204.annoyingex.Messages
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ApiManager(private val exMessagesService: ExMessagesService) {

    fun getMessages(onReady: (Messages) -> Unit, onError: (() -> Unit)?) {
        exMessagesService.fetchMessages().enqueue(object:Callback,
            retrofit2.Callback<Messages> {
            override fun onFailure(call: Call<Messages>, t: Throwable) {
                onError?.invoke()
            }

            override fun onResponse(call: Call<Messages>, response: Response<Messages>) {
                val messages = response.body()
                if(messages != null) {
                    onReady(messages)
                } else {
                    onError?.invoke()
                }
            }
        })
    }

}