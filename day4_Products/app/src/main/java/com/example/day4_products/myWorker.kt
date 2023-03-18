package com.example.day4_products

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream

class myWorker(private var appContext:Context, private var workerParameters: WorkerParameters  ) : Worker(appContext , workerParameters) {
    var url :String = "https://dummyjson.com/"
    override fun doWork(): Result {
        var gson = GsonBuilder().setLenient().create()
        val retrofit :Retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create(gson)).build()
        val myApi : Api = retrofit.create(Api::class.java)
        val call : Call<MyResponse> = myApi.getProducts()
        var result =call.execute()
        var data = result.body()
        var json = Gson().toJson(data).toByteArray()
        val outputfile = File(applicationContext.cacheDir , "Product File")
        FileOutputStream(outputfile).write(json,0,json.size)
        return Result.success(workDataOf("My Products" to outputfile.absolutePath))
    }
}