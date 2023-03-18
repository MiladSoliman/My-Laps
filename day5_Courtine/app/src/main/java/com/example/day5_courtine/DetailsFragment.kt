package com.example.day5_courtine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class DetailsFragment : Fragment() {
    lateinit var desc : TextView
    lateinit var myProduct: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        desc = view.findViewById(R.id.dec)
        if (savedInstanceState!=null){
            var p = savedInstanceState.getSerializable("MyData") as Product
            setData(p)
        }


    }


    fun setData(proudcts: Product){
        myProduct = proudcts
        desc.text = proudcts.description
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("MyData" ,myProduct )
    }


}