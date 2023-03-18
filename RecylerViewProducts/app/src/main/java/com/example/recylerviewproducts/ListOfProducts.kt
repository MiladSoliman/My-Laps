package com.example.recylerviewproducts

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager


class ListOfProducts : Fragment() , OnClick {
    lateinit var recyclerview:RecyclerView
    lateinit var myAdapter: MyAdapter

    lateinit var  listener:Commincator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_of_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview = view.findViewById(R.id.rv_products)

     //  manager = LinearLayoutManager(activity)
     //   recyclerview.adapter = myAdapter
       recyclerview.apply {
            adapter = MyAdapter(RecycleRepo.getPriducts() , this@ListOfProducts)
           layoutManager = LinearLayoutManager(activity)
              //  orientation = RecyclerView.VERTICAL
        }

        Log.i("Milad" , RecycleRepo.getPriducts().get(0).name)

    }

    override fun OnClick(product: Product) {
      if (resources.configuration.orientation== Configuration.ORIENTATION_PORTRAIT) {
          Toast.makeText(activity, "" + product.name, Toast.LENGTH_SHORT).show()
          val intent = Intent(activity, Detalis_Activity::class.java)
          intent.putExtra("object", product)
          startActivity(intent)
      }else{
          listener = activity as Commincator
          listener.setData(product)
      }


    }


}