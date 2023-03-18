package com.example.day3_downloadimage

import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var url:TextView
    lateinit var download:Button
    companion object{
        lateinit var imgURL :String
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        url = findViewById(R.id.tv_url)
        download = findViewById(R.id.button)
        imgURL = url.text.toString()

        download.setOnClickListener {
            val intent = Intent(this@MainActivity , MyJob::class.java)
            MyJob.enqueueWork(this,intent)
        }
        val intentFilter : IntentFilter = IntentFilter("Downloaded")
        var reciver = MyReceiver()
        registerReceiver(reciver,intentFilter)

    }




}