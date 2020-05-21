package com.towm1204.annoyingex

import android.app.Application
import android.app.NotificationManager
import android.content.Context
import androidx.work.WorkManager
import com.towm1204.annoyingex.manager.ApiManager
import com.towm1204.annoyingex.manager.ExsNotificationManager
import com.towm1204.annoyingex.manager.MessageRequestManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

class AnnoyingExApp: Application() {
    var masterMessageList: List<String> = listOf("Unable to retrieve messages")
    lateinit var apiManager: ApiManager
    lateinit var messageRequestManager: MessageRequestManager
    lateinit var notificationManager: ExsNotificationManager

    override fun onCreate() {
        super.onCreate()
        messageRequestManager = MessageRequestManager(this)
        notificationManager = ExsNotificationManager(this)

        // initialize retrofit to create ExMessagesService and pass into api manager
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        this.apiManager = ApiManager(retrofit.create(ExMessagesService::class.java))

    }

    fun getMessage(): String {
        return masterMessageList[Random.nextInt(0, masterMessageList.size + 1)]
    }
}