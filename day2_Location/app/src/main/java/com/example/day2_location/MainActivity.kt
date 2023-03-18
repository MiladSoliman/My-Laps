package com.example.day2_location

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location

import android.location.LocationManager
import android.location.LocationRequest
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import java.util.*

const val PERMISSION_ID = 44

class MainActivity : AppCompatActivity() {
    lateinit var lad:TextView
    lateinit var long:TextView
    lateinit var geo:TextView
    lateinit var send:Button
    lateinit var mFusedLocationClient:FusedLocationProviderClient
    lateinit var geo2:TextView
    lateinit var country :String
    lateinit var countryCode :String
    lateinit var  laditude_milad : String
   lateinit var longitude_milad :String
    lateinit var map:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lad = findViewById(R.id.tv_latitude)
        long = findViewById(R.id.tv_lang)
        geo = findViewById(R.id.tv_geo)
        geo2 = findViewById(R.id.geo2)
        send = findViewById(R.id.btn_send)
        map = findViewById(R.id.map)
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getLastLocation()



        send.setOnClickListener {
            val uri = Uri.parse("smsto:01283404095")
            val intent = Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra(Intent.EXTRA_TEXT,country + " " +countryCode)
            startActivity(intent)
        }


        map.setOnClickListener {
            val uri = Uri.parse("geo:?q=$laditude_milad,$longitude_milad")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }



    }

    override fun onResume() {
        super.onResume()
        getLastLocation()
    }



    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        if(checkPermissions()){
            if(isLocationEnabled()){
                requestNewLocationData()
            }else{
                Toast.makeText(this,"Please Turn on location ",Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        }else{
            requestPermissions()
        }
    }



    private fun isLocationEnabled(): Boolean {
         val locationManger:LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManger.isProviderEnabled(LocationManager.GPS_PROVIDER)||locationManger.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }


    private fun checkPermissions(): Boolean {
      return ActivityCompat.checkSelfPermission(
          this,
          android.Manifest.permission.ACCESS_COARSE_LOCATION
      )==PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
          this,
          android.Manifest.permission.ACCESS_FINE_LOCATION
      )==PackageManager.PERMISSION_GRANTED

    }


   private fun requestPermissions(){
       ActivityCompat.requestPermissions(
           this ,
           arrayOf(
               android.Manifest.permission.ACCESS_COARSE_LOCATION,
               android.Manifest.permission.ACCESS_FINE_LOCATION
           ),
           PERMISSION_ID
       )
   }

   override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
       if (requestCode== PERMISSION_ID){
           if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
               getLastLocation()
           }
       }
    }


    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
       val mLocationRequest = com.google.android.gms.location.LocationRequest()
        mLocationRequest.setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY)
        mLocationRequest.setInterval(0)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mFusedLocationClient.requestLocationUpdates(
            mLocationRequest , mLocationCallBack, Looper.myLooper()
        )
    }


    private val mLocationCallBack : LocationCallback = object : LocationCallback(){
        override fun onLocationResult(locationResult: LocationResult?) {
            val mlastLocation : Location = locationResult?.lastLocation!!
            lad.text = mlastLocation.latitude.toString()
            long.text = mlastLocation.longitude.toString()
            laditude_milad  =mlastLocation.latitude.toString()
            longitude_milad =mlastLocation.longitude.toString()
            val geocoder = Geocoder(this@MainActivity, Locale.getDefault())
            var address:List<Address> = geocoder.getFromLocation(mlastLocation.latitude,mlastLocation.longitude,1) as List<Address>
            Log.i("milad",""+address[0].toString())
            geo.text = address[0].countryName.toString()
            geo2.text = address[0].countryCode.toString()
            country = address[0].countryName.toString()
            countryCode = address[0].countryCode.toString()


        }
    }






}