package com.example.day3_boundactivity

import android.app.Service
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Binder
import android.os.IBinder
import java.util.*

class MyBoundService : Service() {

    var myBinder:IBinder = MyBinder()

    override fun onBind(intent: Intent): IBinder {
        return myBinder
    }

    fun getTime():String{
        val dateFormat = SimpleDateFormat("HH:mm:ss mm/dd/yyyy", Locale.US)
        return dateFormat.format(Date())
    }


    inner class MyBinder: Binder(){
        fun getBiundService():MyBoundService{
            return this@MyBoundService
        }
    }
}