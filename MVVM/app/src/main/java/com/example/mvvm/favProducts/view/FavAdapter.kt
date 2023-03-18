package com.example.mvvm.favProducts.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm.R
import com.example.mvvm.allProducts.view.AllAdapter
import com.example.mvvm.allProducts.view.OnClick
import com.example.mvvm.model.Product

class FavAdapter (var proudcts: List<Product>, var listener: OnDelete, var context: Context) :
    RecyclerView.Adapter<FavAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fav_products, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.i("Milad and Mina", "" + proudcts.size)
        return proudcts.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var product: Product = proudcts[position]
        holder.proName.text = product.title
        holder.proBrand.text = product.brand
        holder.proPrice.text=product.price
        holder.prodesc.text=product.description
        Glide.with(context).load(product.thumbnail).into(holder.img)
        holder.delete.setOnClickListener(View.OnClickListener {
            listener.deleteProduct(product)
        })
    }


    inner class ViewHolder(private val itemview: View) : RecyclerView.ViewHolder(itemview) {
        val proName: TextView = itemview.findViewById(R.id.tv_title)
        val proBrand: TextView = itemview.findViewById(R.id.tv_brand)
        val proPrice: TextView = itemview.findViewById(R.id.tv_price)
        val prodesc: TextView = itemview.findViewById(R.id.tv_desc)
        val img: ImageView = itemview.findViewById(R.id.imageView)
        val delete: Button = itemview.findViewById(R.id.btn_remove)
    }
}