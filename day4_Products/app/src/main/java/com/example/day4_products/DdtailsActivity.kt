package com.example.day4_products

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DdtailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ddtails)
    }

    override fun onStart() {
        super.onStart()
        if(resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE) {
            finish()
        }else{
            val proudcts = intent.getSerializableExtra("My Proudct") as Product
            val secondFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as DetailsFragment
             secondFragment.setData(proudcts)
        }
    }
}