package com.example.recylerviewproducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment


class DetailsFragment : Fragment() {
   lateinit var prodName:TextView
   lateinit var prodImag:ImageView
   lateinit var product: Product

  // lateinit var title:String
  //  var photo :Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      /*  if (savedInstanceState!=null){
            title = savedInstanceState.get("one") as String
            photo = savedInstanceState.getInt("two")
        }*/

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       /*  if (savedInstanceState!=null){
            product = savedInstanceState.getSerializable("data") as Product
        }*/
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prodName = view.findViewById(R.id.name_details)
        prodImag = view.findViewById(R.id.img_detalis)

        var bundle = arguments
        if (bundle!=null){
          product = bundle?.get("object") as Product

      }
       /* else if (savedInstanceState!=null){
            product = savedInstanceState.getSerializable("data") as Product
        }*/

       //  title  = bundle?.get("Name") as String
        // photo  = bundle?.getInt("image") as Int
       prodName.text=product.name
        prodImag.setImageResource(product.img)

    }

  override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
       // outState.putSerializable("object",product)
   //   outState.putString("one",title)
     // outState.putInt("two",photo)
    }




}