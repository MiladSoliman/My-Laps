package com.example.fragmentstudying

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() , OnClick {
    var myNames: List<Name> = listOf(Name("Milad"),Name("fghjjjb "),Name("cadaf"),Name("qwweqe"),Name("fff"),Name("88888"),Name("safhasf"))
    lateinit var recyclerView: RecyclerView
    lateinit var ad:NameAdabter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      recyclerView = findViewById(R.id.main_rv)
        ad = NameAdabter(myNames , this )
       recyclerView.apply {
           adapter=ad
           layoutManager = LinearLayoutManager(this@MainActivity)
       }

    }

    override fun click(name: Name) {
        var bundle:Bundle = Bundle()
        bundle.putString("myName",name.n)
        var first:FisrtFragment = FisrtFragment()
        first.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.my_contaner,first).commit()
    }
}