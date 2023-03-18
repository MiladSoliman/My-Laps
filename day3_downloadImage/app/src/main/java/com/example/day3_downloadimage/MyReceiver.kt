package com.example.day3_downloadimage

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri

class MyReceiver () : BroadcastReceiver() {
    lateinit var context1: Context
    lateinit var img:Uri
    override fun onReceive(context: Context, intent: Intent  ) {
        this.context1 = context
        val shareIntent = Intent(context , PhotoActivity::class.java)
        shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        shareIntent.putExtra("Image", MyJob.imgBitmapUri.toString())
        shareIntent.type = "image/png"
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        //  shareIntent.putExtra(Intent.EXTRA_TEXT)
        // Open the chooser dialog box
       // val i = Intent()
        context1.startActivity(Intent.createChooser(shareIntent, "Share with"))
    }

}