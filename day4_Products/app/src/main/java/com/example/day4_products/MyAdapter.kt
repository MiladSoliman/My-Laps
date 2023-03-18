package com.example.day4_products

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MyAdapter(private val proudcts: ArrayList<Product>, var listener:OnClick , var context:Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.i("eshta", "" + proudcts.size)
        return proudcts.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var product: Product = proudcts[position]
        holder.proName.text = product.title
        //holder.img.setImageResource(product.img)
        Glide.with(context).load(product.thumbnail).into(holder.img)
        holder.cons?.setOnClickListener(View.OnClickListener {
            listener.onClick(product)
        })
        holder.rate.rating= product.rating.toFloat()
        holder.rate.isEnabled=false
    }


    inner class ViewHolder(private val itemview: View) : RecyclerView.ViewHolder(itemview) {
        val proName: TextView = itemview.findViewById(R.id.tv_name)
        val img: ImageView = itemview.findViewById(R.id.pro_image_view)
        val cons: View? = itemview.findViewById(R.id.onClick_layout)
        val rate:RatingBar = itemview.findViewById(R.id.ratingBar)
    }
}

