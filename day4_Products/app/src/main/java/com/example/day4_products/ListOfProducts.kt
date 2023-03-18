package com.example.day4_products

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream

class ListOfProducts : Fragment() {
    lateinit var recyclerview: RecyclerView
    lateinit var  listener:OnClick
     var myAdapter :MyAdapter? = null
    lateinit var myList :ArrayList<Product>

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
        var context :Context = requireContext()

        val workManager =WorkManager.getInstance(requireContext())

        val myRequest =
            OneTimeWorkRequestBuilder<myWorker>()
                .addTag("download")
                .build()

        workManager.enqueueUniqueWork("dwonload products", ExistingWorkPolicy.REPLACE, myRequest)
        workManager.getWorkInfosByTagLiveData("download").observe(requireActivity() , Observer { workInfos ->
            val myInfos = workInfos?.find { it.id == myRequest.id }
            when (myInfos?.state) {
                WorkInfo.State.SUCCEEDED -> {
                    val outputPath = myInfos.outputData.getString("My Products")!!
                    val json = FileInputStream(File(outputPath)).reader()
                        .use { it.readText() }
                    var gson = Gson()
                    val list = gson.fromJson(json,MyResponse::class.java)
                     myList = list.products
                    Log.i("Done", "" + myList[0].title)
                    myAdapter = MyAdapter(myList,listener,context)

                   recyclerview.apply {
                        adapter = myAdapter
                        layoutManager = LinearLayoutManager(activity)
                    }
                }

                WorkInfo.State.FAILED -> {
                    Log.i("Milad", "Error")
                }
                else -> {}
            }

        })


    }
}






