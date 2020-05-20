package com.towm1204.annoyingex.manager

import android.app.ApplicationErrorReport
import android.content.Context
import androidx.work.*
import com.towm1204.annoyingex.ExsWorker
import java.util.concurrent.TimeUnit

class NotificationManager(private val context: Context) {
    companion object {
        const val EX_WORKER_TAG = "notification_manager_xD"
    }
    private var workManager: WorkManager = WorkManager.getInstance(context)

    fun startSendingMessage() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val workRequest = OneTimeWorkRequestBuilder<ExsWorker>()
            .setInitialDelay(5, TimeUnit.SECONDS)
            //.setConstraints(constraints)
            .addTag(EX_WORKER_TAG)
            .build()

        workManager.enqueue(workRequest)

    }

    fun stopAllWorkers() {
        workManager.cancelAllWorkByTag(EX_WORKER_TAG)
    }
}