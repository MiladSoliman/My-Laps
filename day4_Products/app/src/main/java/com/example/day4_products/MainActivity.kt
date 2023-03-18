package com.example.day4_products

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() , OnClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(proudcts:Product) {
        if(resources.configuration.orientation==Configuration.ORIENTATION_PORTRAIT){
            val intent = Intent(this, DdtailsActivity::class.java)
            intent.putExtra("My Proudct",proudcts)
            startActivity(intent)
        }else{
            val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView4) as DetailsFragment
            fragment.setData(proudcts)

        }
    }
}