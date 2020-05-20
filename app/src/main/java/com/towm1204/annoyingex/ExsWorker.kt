package com.towm1204.annoyingex

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
class ExsWorker(private val context: Context, workParams: WorkerParameters):Worker(context, workParams) {

    override fun doWork(): Result {
        val app: AnnoyingExApp = applicationContext as AnnoyingExApp
        Log.i("Toww", app.masterMessageList[0])
        return Result.success()
    }

}