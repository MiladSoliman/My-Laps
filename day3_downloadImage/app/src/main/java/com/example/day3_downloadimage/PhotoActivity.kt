package com.example.day3_downloadimage

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PhotoActivity : AppCompatActivity() {
    lateinit var img:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        img = findViewById(R.id.second_Image)

        val i = intent
        var uri = Uri.parse(i.getStringExtra("Image"))

        img.setImageURI(uri)

    }
}