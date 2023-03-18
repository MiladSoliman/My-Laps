package com.example.day3_downloadimage

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import androidx.core.app.JobIntentService
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.random.Random


class MyJob() : JobIntentService() {
    companion object {
        val JOB_ID = 10
        lateinit var context: Context
        fun enqueueWork(context:Context , work :Intent){
           // this.context=context
            enqueueWork(context,MyJob::class.java , JOB_ID ,work)
        }
        lateinit var imgBitmapUri :Uri
    }

    override fun onHandleWork(intent: Intent) {
        var url :URL?=null
        url = URL(MainActivity.imgURL)
        assert (url!=null)
        var connection = url!!.openConnection()as HttpURLConnection
        assert(connection!=null)
        connection.doInput = true

        var input :InputStream? = null
         input = connection.inputStream
        val imgBitmap = BitmapFactory.decodeStream(input)
        val rand = Random
        val randNo = rand.nextInt(100000)
        val imgBitmapPath = MediaStore.Images.Media.insertImage(
            contentResolver, imgBitmap,
            "IMG:$randNo", null
        )
         imgBitmapUri = Uri.parse(imgBitmapPath)
         broadCast()

    }

    fun broadCast(){
        val intent = Intent()
        intent.action = "Downloaded"
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        sendBroadcast(intent)
    }


}