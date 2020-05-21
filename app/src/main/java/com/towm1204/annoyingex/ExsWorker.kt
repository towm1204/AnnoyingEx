package com.towm1204.annoyingex

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlin.random.Random

class ExsWorker(private val context: Context, workParams: WorkerParameters):Worker(context, workParams) {

    override fun doWork(): Result {
        val app: AnnoyingExApp = (applicationContext as AnnoyingExApp)
        (applicationContext as AnnoyingExApp).notificationManager.postNotif(app.getMessage())
        return Result.success()
    }

}