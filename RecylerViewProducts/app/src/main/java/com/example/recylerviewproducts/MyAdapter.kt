package com.example.recylerviewproducts

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val products: List<Product> , var listener:OnClick) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.i("eshta" , ""+products.size)
       return products.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var product : Product = products[position]
        holder.proName.text = product.name
        holder.img.setImageResource(product.img)
        holder.cons?.setOnClickListener(View.OnClickListener {
            listener.OnClick(product)
        })

    }


    inner class ViewHolder(private val itemview:View):RecyclerView.ViewHolder(itemview){
          val proName :TextView = itemview.findViewById(R.id.tv_name)
          val img : ImageView = itemview.findViewById(R.id.pro_image_view)
          val cons: View? = itemview.findViewById(R.id.onClick_layout)

    }

}

