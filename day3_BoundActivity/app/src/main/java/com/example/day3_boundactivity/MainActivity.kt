package com.example.day3_boundactivity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var dateandtime:TextView
    lateinit var getDate:Button
    lateinit var myService:MyBoundService
    var isBound:Boolean = false
    lateinit var mydate :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dateandtime = findViewById(R.id.tv_date)
        getDate = findViewById(R.id.button)


        val intent = Intent(this,MyBoundService::class.java)
        bindService(intent,myConniction,Context.BIND_AUTO_CREATE)


        getDate.setOnClickListener {
            mydate = myService.getTime()
            dateandtime.text = mydate
        }

    }


    private var myConniction : ServiceConnection = object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
          val binder : MyBoundService.MyBinder = service as MyBoundService.MyBinder
           myService=binder.getBiundService()
            isBound=true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound=false
        }
    }
}