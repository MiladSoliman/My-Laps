package com.example.recylerviewproducts

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() , Commincator{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun setData(product: Product) {
        var manager = supportFragmentManager
        manager.beginTransaction().add(LandFragment(),"Tag").commit()
        var fragment = manager.findFragmentById(R.id.fragmentContainerView4) as LandFragment
        fragment.shwoData(product)
    }
}