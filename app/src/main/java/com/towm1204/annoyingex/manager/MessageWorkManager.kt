package com.towm1204.annoyingex.manager

import android.app.ApplicationErrorReport
import android.content.Context
import android.widget.Toast
import androidx.work.*
import com.towm1204.annoyingex.ExsWorker
import java.util.*
import java.util.concurrent.TimeUnit

class MessageWorkManager(private val context: Context) {
    companion object {
        const val EX_WORKER_TAG = "notification_manager_xD"
    }
    private var workManager: WorkManager = WorkManager.getInstance(context)
    var lastWRId: UUID? = null

    fun startSendingMessage() {
        if (lastWRId != null && wrRunning()) {
            Toast.makeText(context, "Ex already texting", Toast.LENGTH_SHORT).show()
        } else {
            val constraints = Constraints.Builder()
                .setRequiresCharging(true)
                .build()

            val workRequest = PeriodicWorkRequestBuilder<ExsWorker>(15, TimeUnit.MINUTES)
                .setInitialDelay(10, TimeUnit.SECONDS)
                //.setConstraints(constraints)
                .addTag(EX_WORKER_TAG)
                .build()

            lastWRId = workRequest.id
            workManager.enqueue(workRequest)
        }

    }

    private fun wrRunning(): Boolean {
        return workManager.getWorkInfoById(lastWRId!!).get().state == WorkInfo.State.ENQUEUED ||
                workManager.getWorkInfoById(lastWRId!!).get().state == WorkInfo.State.RUNNING
    }

    fun stopAllWR() {
        if (lastWRId == null) {

        } else{
            workManager.cancelWorkById(lastWRId!!)
        }
    }
}