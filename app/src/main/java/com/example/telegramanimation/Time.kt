package com.example.telegramanimation

import android.annotation.SuppressLint
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object Time {
    @SuppressLint("SimpleDateFormat")
    fun timeStamp(): String {
        val timeStamp = Timestamp(System.currentTimeMillis())
        val msh = SimpleDateFormat("HH:mm")
        val time = msh.format(Date(timeStamp.time))

        return time.toString()
    }
}