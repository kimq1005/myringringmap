package com.example.mymap

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.mymap.databinding.ActivityMainMapBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*

class Main_Map : AppCompatActivity(), OnMapReadyCallback {

    private var index = 0
    private val builder: LatLngBounds.Builder = LatLngBounds.builder()
    private val ZoomLevel: Int = 12
    private var size_check: Int = 0
    private var mLastClickTime: Long = 0

    private lateinit var marker_view: View
    private lateinit var tag_marker: TextView

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    companion object {
        var selectedMarker: Marker? = null
    }


    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMainMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        marker_view = LayoutInflater.from(this).inflate(R.layout.marker_layout,null)
        tag_marker = marker_view.findViewById(R.id.tag_marker) as TextView
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)


        var latlngdata = arrayListOf<LatLngData>()

        latlngdata.add(LatLngData(1, LatLng(35.162339, 129.108509), "가"))
        latlngdata.add(LatLngData(2, LatLng(35.224836, 129.088285), "나"))
        latlngdata.add(LatLngData(3, LatLng(35.080117, 129.048376), "다"))

        for (i in latlngdata.indices) {
            addMarker(latlngdata[i], false)
        }









       addMarker(LatLngData(1,LatLng(-34.0, 151.0),"ㅎㅇ"),false)
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))


    }

    private fun addMarker(latlngdata: LatLngData, isSelectedMarker:Boolean): Marker? {
        var list: List<Address>? = null
        var markerOptions = MarkerOptions()
        if (isSelectedMarker) {
            tag_marker.setBackgroundResource(R.drawable.ic_launcher_foreground)
            tag_marker.setTextColor(Color.WHITE)
        } else {
            tag_marker.setBackgroundResource(R.drawable.ic_launcher_background)
            tag_marker.setTextColor(Color.BLACK)
        }

        markerOptions.position(latlngdata.latlng)
        tag_marker.setText(latlngdata.tag)
        markerOptions.icon(
            BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker_view
            )
            )
        )
        return mMap.addMarker(markerOptions)
    }



    private fun createDrawableFromView(context: Context, view: View): Bitmap {
        val displayMetrics = DisplayMetrics()
        (context as Activity).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics)
        view.setLayoutParams(
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels)
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels)
        view.buildDrawingCache()
        val bitmap: Bitmap = Bitmap.createBitmap(
            view.getMeasuredWidth(),
            view.getMeasuredHeight(),
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }
}