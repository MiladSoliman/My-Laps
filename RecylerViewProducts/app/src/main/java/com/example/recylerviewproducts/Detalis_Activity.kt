package com.example.recylerviewproducts

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction

class Detalis_Activity : AppCompatActivity() {
    lateinit var detailsFragment: DetailsFragment
    lateinit var fragmentTransaction: FragmentTransaction
    lateinit var product: Product
    lateinit var bundle :Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalis)
        detailsFragment = DetailsFragment()
        var i = intent
        product = i.getSerializableExtra("object") as Product
        bundle = Bundle()
     bundle.putSerializable("object", product)

        fragmentTransaction = supportFragmentManager.beginTransaction()
        detailsFragment.arguments = bundle
        fragmentTransaction.add(R.id.fragmentContainerView2, detailsFragment, "details")
        fragmentTransaction.commit()

        if (this.applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


   /* override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putBundle("data" ,bundle)
    }*/

}



//}


