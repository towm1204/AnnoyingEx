package com.towm1204.annoyingex

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import retrofit2.Call
import retrofit2.http.GET

interface ExMessagesService {
    @GET("echeeUW/codesnippets/master/ex_messages.json")
    fun fetchMessages(): Call<Messages>
}

@Parcelize
data class Messages(val messages: List<String>): Parcelable
