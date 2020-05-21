package com.towm1204.annoyingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.towm1204.annoyingex.manager.ApiManager
import com.towm1204.annoyingex.manager.MessageRequestManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var apiManager: ApiManager
    private lateinit var messageRequestManager: MessageRequestManager
    private lateinit var annoyingExApp: AnnoyingExApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        annoyingExApp = (application as AnnoyingExApp)
        apiManager = annoyingExApp.apiManager
        messageRequestManager = annoyingExApp.messageRequestManager



        // fetch data at launch
        if (savedInstanceState == null) {
            apiManager.getMessages({
                annoyingExApp.masterMessageList = it.messages
            }, {
                Toast.makeText(this, "Error Fetching Data", Toast.LENGTH_LONG).show()
            })
        }

        btnHereWeGoAgain.setOnClickListener {
            messageRequestManager.startSendingMessage()
        }

        btnClosure.setOnClickListener {
            messageRequestManager.stopAllWR()
        }
        if (intent.getStringExtra("msg") != null) {
            tvNotificationFeedback.text = "Message Viewed: ${intent.getStringExtra("msg")}"
            tvNotificationFeedback.visibility = View.VISIBLE
        }



    }
}
