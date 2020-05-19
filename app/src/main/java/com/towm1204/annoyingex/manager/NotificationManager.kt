package com.towm1204.annoyingex.manager

import android.app.ApplicationErrorReport
import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.towm1204.annoyingex.ExsWorker
import java.util.concurrent.TimeUnit

class NotificationManager(private val context: Context) {
    private var workManager: WorkManager = WorkManager.getInstance(context)

    fun startSendingMessage() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val workRequest = OneTimeWorkRequestBuilder<ExsWorker>()
            .setInitialDelay(5, TimeUnit.SECONDS)
            //.setConstraints(constraints)
            .build()

        workManager.enqueue(workRequest)

    }
}