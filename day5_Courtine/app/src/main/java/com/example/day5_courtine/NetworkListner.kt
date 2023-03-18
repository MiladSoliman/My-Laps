package com.example.day5_courtine

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

class NetworkListener {
    companion object {
        @SuppressLint("ServiceCast")
        fun getConnectivity(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null
        }
    }
}