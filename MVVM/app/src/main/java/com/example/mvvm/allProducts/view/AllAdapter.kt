package com.example.mvvm.allProducts.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm.R
import com.example.mvvm.model.Product

class AllAdapter ( var proudcts: List<Product>, var listener:OnClick, var context: Context) :
    RecyclerView.Adapter<AllAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.all_products, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.i("eshta", "" + proudcts.size)
        return proudcts.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var product: Product = proudcts[position]
        holder.proName.text = product.title
        holder.proBrand.text = product.brand
        holder.proPrice.text=product.price
        holder.prodesc.text=product.description
        Glide.with(context).load(product.thumbnail).into(holder.img)
        holder.add.setOnClickListener(View.OnClickListener {
            listener.addToFavurote(product)
        })
    }


    inner class ViewHolder(private val itemview: View) : RecyclerView.ViewHolder(itemview) {
        val proName: TextView = itemview.findViewById(R.id.tv_title)
        val proBrand: TextView = itemview.findViewById(R.id.tv_brand)
        val proPrice: TextView = itemview.findViewById(R.id.tv_price)
        val prodesc: TextView = itemview.findViewById(R.id.tv_desc)
        val img: ImageView = itemview.findViewById(R.id.imageView2)
        val add:Button = itemview.findViewById(R.id.btn_addToFavourite)
    }
}