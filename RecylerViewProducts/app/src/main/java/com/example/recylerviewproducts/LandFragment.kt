package com.example.recylerviewproducts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class LandFragment : Fragment() {

       var imageView: ImageView?=null
       var title:TextView?=null

    fun shwoData(product: Product){
        imageView?.setImageResource(product.img)
        title?.text = product.name
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_land, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       imageView = view.findViewById(R.id.imag_land)
        title = view.findViewById(R.id.name_land)

    }
    
}