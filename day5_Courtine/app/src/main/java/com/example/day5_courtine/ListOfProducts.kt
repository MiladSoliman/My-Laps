package com.example.day5_courtine

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ListOfProducts : Fragment() {
    lateinit var myList : List<Product>
    lateinit var recyclerview: RecyclerView
    lateinit var  listener:OnClick
    var myAdapter :MyAdapter? = null
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
        recyclerview = view?.findViewById(R.id.products_recy)!!
        listener = activity as OnClick
        var context : Context = requireContext()
        val myProductDao : ProductDao by lazy{
            ProductDatabase.getInstance (context).getProductDao()
        }


        lifecycleScope.launch(Dispatchers.IO){
            if (NetworkListener.getConnectivity(context)){
                val response = MyApi.retrofirService.getProducts()
                if(response.isSuccessful) {
                    myList = response.body()?.products ?: listOf<Product>()
                    myList.forEach {
                       var res = myProductDao.addProduct(it)
                    }
                    Log.i("Done", myList[0].title)
                }else{
                    Log.i("error"," "+response.errorBody())
                }
            }else {
                myList = myProductDao.getAll()
            }
              withContext(Dispatchers.Main){
                  //  myAdapter = MyAdapter (myList , listener , context )
                    recyclerview.apply {
                        adapter = MyAdapter(myList , listener , context)
                        layoutManager = LinearLayoutManager(activity)
                    }
                }
            }
        }

}

