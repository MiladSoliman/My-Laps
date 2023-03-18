package com.example.fragmentstudying

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NameAdabter(private val names: List<Name> , var listener:OnClick) :
    RecyclerView.Adapter<NameAdabter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.name_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.i("eshta", "" + names.size)
        return names.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var name: Name = names[position]
        holder.proName.text=name.n
        holder.proName.setOnClickListener {
            listener.click(name)
        }
    }


    inner class ViewHolder(private val itemview: View) : RecyclerView.ViewHolder(itemview) {
        val proName: TextView = itemview.findViewById(R.id.tv_name)

    }
}