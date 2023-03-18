package com.example.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mvvm.allProducts.view.AllProductsActivity
import com.example.mvvm.favProducts.view.FavProducts

class MainActivity : AppCompatActivity() {
    lateinit var all :Button
    lateinit var exit:Button
    lateinit var fav:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        all = findViewById(R.id.btn_allproudcts)
        exit = findViewById(R.id.btn_finish)
        fav = findViewById(R.id.btn_favProduct)
        all.setOnClickListener {
            var intent = Intent(this,AllProductsActivity::class.java)
            startActivity(intent)
        }
        exit.setOnClickListener {
            finish()
        }

        fav.setOnClickListener {
            var intent = Intent(this,FavProducts::class.java)
            startActivity(intent)
        }
    }
}