package com.example.fragmentstudying

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FisrtFragment : Fragment() {
    lateinit var text:TextView
    lateinit var myName :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle = arguments
        if (bundle!=null){
            myName = bundle.getString("myName").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      var v :View =  inflater.inflate(R.layout.fragment_fisrt, container, false)
        text = v.findViewById(R.id.fragment_name)
        text.text=myName
        return v
    }


}