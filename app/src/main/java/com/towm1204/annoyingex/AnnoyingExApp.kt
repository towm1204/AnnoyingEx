package com.towm1204.annoyingex

import android.app.Application
import android.content.Context
import androidx.work.WorkManager
import com.towm1204.annoyingex.manager.ApiManager
import com.towm1204.annoyingex.manager.MessageWorkManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnnoyingExApp: Application() {
    var masterMessageList: List<String> = listOf()
    lateinit var apiManager: ApiManager
    lateinit var notificationManager: MessageWorkManager

    override fun onCreate() {
        super.onCreate()
        notificationManager = MessageWorkManager(this)

        // initialize retrofit to create ExMessagesService and pass into api manager
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        this.apiManager = ApiManager(retrofit.create(ExMessagesService::class.java))

    }
}