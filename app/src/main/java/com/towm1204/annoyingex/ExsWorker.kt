package com.towm1204.annoyingex

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class ExsWorker(context: Context, workParams: WorkerParameters):Worker(context, workParams) {

    override fun doWork(): Result {
        Log.i("Toww", "iz me ur ex")
        return Result.success()
    }

}