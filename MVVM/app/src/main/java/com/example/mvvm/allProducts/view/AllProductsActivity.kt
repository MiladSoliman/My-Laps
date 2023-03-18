package com.example.mvvm.allProducts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.allProducts.viewmodel.AllProductsViewModel
import com.example.mvvm.allProducts.viewmodel.AllProductsViewModelFactory
import com.example.mvvm.database.ConcretLocalSource
import com.example.mvvm.model.Product
import com.example.mvvm.model.Repository
import com.example.mvvm.network.ProductClient

class AllProductsActivity : AppCompatActivity() , OnClick{
    lateinit var allFactory:AllProductsViewModelFactory
    lateinit var viewModel:AllProductsViewModel
    lateinit var allRecycler:RecyclerView
    lateinit var allAdapter: AllAdapter
    lateinit var mylayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_products)
        allRecycler = findViewById(R.id.all_rv)
        allAdapter  = AllAdapter(listOf(),this,this)
        mylayoutManager = LinearLayoutManager(this)
        allRecycler.layoutManager = mylayoutManager
        allRecycler.adapter = allAdapter
        allFactory = AllProductsViewModelFactory(Repository.getInstance(ProductClient.getInstance() ,ConcretLocalSource.getInstance(this)))
        viewModel = ViewModelProvider(this,allFactory).get(AllProductsViewModel::class.java)
        viewModel._myProducts.observe(this){products->

            if (products!=null){
                allAdapter.proudcts = products
                allAdapter.notifyDataSetChanged()
                Log.i("Milad",""+products.get(0))
                System.out.println(" MILAD SOLIMAN"+products.get(0))
            }
        }
    }


    override fun addToFavurote(product: Product) {
      viewModel.addProduct(product)
      Toast.makeText(this,"Added To Favourite",Toast.LENGTH_SHORT).show()
    }


}