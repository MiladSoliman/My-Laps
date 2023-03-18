package com.example.mvvm.favProducts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.allProducts.view.AllAdapter
import com.example.mvvm.allProducts.viewmodel.AllProductsViewModel
import com.example.mvvm.allProducts.viewmodel.AllProductsViewModelFactory
import com.example.mvvm.database.ConcretLocalSource
import com.example.mvvm.favProducts.viewmodel.FavProductsViewModel
import com.example.mvvm.favProducts.viewmodel.FavProductsViewModelFactory
import com.example.mvvm.model.Product
import com.example.mvvm.model.Repository
import com.example.mvvm.network.ProductClient

class FavProducts : AppCompatActivity() , OnDelete {
    lateinit var favFactory: FavProductsViewModelFactory
    lateinit var favViewModel: FavProductsViewModel
    lateinit var favRecycler: RecyclerView
    lateinit var favAdapter: FavAdapter
    lateinit var mylayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav_products)
        favRecycler = findViewById(R.id.fav_rv)
        favAdapter = FavAdapter(listOf(),this,this)
        mylayoutManager = LinearLayoutManager(this)
        favRecycler.layoutManager = mylayoutManager
        favRecycler.adapter = favAdapter
        favFactory = FavProductsViewModelFactory(Repository.getInstance(ProductClient.getInstance() , ConcretLocalSource.getInstance(this)))
        favViewModel = ViewModelProvider(this,favFactory).get(FavProductsViewModel::class.java)

        favViewModel._myFavProducts.observe(this){
                favAdapter.proudcts = it
                favAdapter.notifyDataSetChanged()
            }
        }


    override fun deleteProduct(product: Product) {
        favViewModel.removeProduct(product)
        Toast.makeText(this,"Removed From Favourite", Toast.LENGTH_SHORT).show()
    }
}