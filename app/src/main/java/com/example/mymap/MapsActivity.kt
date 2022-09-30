package com.example.mymap

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mymap.Url.Companion.TAG
import com.example.mymap.adapter.TestAdapter

import com.example.mymap.databinding.ActivityMapsBinding
import com.example.mymap.service.Retrofit_Client
import com.example.mymap.service.Retrofit_InterFace
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


//6b684a65456b696d3333794b66704f

class MapsActivity : Fragment(), OnMapReadyCallback, CoroutineScope {
    private lateinit var job: Job

    lateinit var binding : ActivityMapsBinding

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    private lateinit var mMap: GoogleMap

    private var markerPerth:Marker?=null

    private var retrofitInterface: Retrofit_InterFace =
        Retrofit_Client.getClient(Url.MAIN_URL).create(Retrofit_InterFace::class.java)

    private lateinit var testAdapter :TestAdapter

    private lateinit var viewPagerAdapter:ViewPagerAdapter

    lateinit var marker_root_view :View
    lateinit var tv_marker : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ActivityMapsBinding.inflate(inflater , container , false)

        job = Job()
        viewPagerAdapter = ViewPagerAdapter()
        testAdapter = TestAdapter()




        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startProcess()
    }



    private fun yeah(googleMap: GoogleMap) {
        launch(coroutineContext) {
            try {
                withContext(Dispatchers.Main) {
                    val latlngBounds = LatLngBounds.Builder()


                    val call = retrofitInterface.getLibrary()
                    val body = call.body()!!.SeoulPublicLibraryInfo.row
                    val testlist = mutableListOf<TestData>()

                    for (i in body.indices) {


                        val xcnts = body.get(i).XCNTS.toDouble()
                        val ydnts = body.get(i).YDNTS.toDouble()

                        val title = body.get(i).LBRRY_NAME
                        val anydata = body.get(i).ADRES

                        Log.d(TAG, "yeah: $xcnts")
                        val position = LatLng(xcnts, ydnts)

                        testlist.add(TestData(title,anydata))


                        binding.myviewpager.apply {
                            adapter = viewPagerAdapter
                            viewPagerAdapter.submitList(body)
                        }



                        markerPerth?.tag = title
                        markerPerth = googleMap.addMarker(
                            MarkerOptions().position(position)
                                .title(title)
                        )


                        latlngBounds.include(position)
                    }


                    val bounds = latlngBounds.build()
                    val padding = 0

                    val camera = CameraUpdateFactory.newLatLngBounds(bounds, padding)
                    mMap.moveCamera(camera)



                    //마커 클릭시
                    googleMap.setOnMarkerClickListener {marker->

                        binding.cardView.visibility = View.VISIBLE
                        val selectedModel = viewPagerAdapter.currentList.lastOrNull() {
                            it.LBRRY_NAME == marker.tag

                        }
                        Log.d(TAG, "태그가져오기: ${marker.tag}")


                        selectedModel?.let {
                            val position = viewPagerAdapter.currentList.indexOf(it)
                            binding.myviewpager.currentItem = position


                            val X = marker.position.latitude
                            val Y = marker.position.longitude

                            binding.parkName.text= it.LBRRY_NAME


//                            val clicklatlngBounds = LatLngBounds.Builder()
//                            clicklatlngBounds.include(LatLng(X,Y))
//                            val clickbounds = clicklatlngBounds.build()
//                            val camerawow =  CameraUpdateFactory.newLatLngBounds(clickbounds, padding)
//                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(X,Y), 20f))
//                            mMap.moveCamera(camerawow)

                            val selectedlocation = LatLng(X,Y)
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(selectedlocation , 15.0f))
                            Log.d(TAG, "위도 경도: $X , $Y")
                        }


                        true
                    }

                    googleMap.setOnMapClickListener {
                        binding.myviewpager.visibility = View.GONE
                        binding.cardView.visibility = View.GONE
                    }





//                    binding.myviewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//                        override fun onPageSelected(position: Int) {
//                            super.onPageSelected(position)
//
//                            val testlatbounce =  LatLngBounds.Builder()
//
//
//                            val seletedmodel = viewPagerAdapter.currentList[position]
//                            val position2 = LatLng(seletedmodel.XCNTS.toDouble(), seletedmodel.YDNTS.toDouble())
//                            testlatbounce.include(position2)
//
//                            val wowbounce = testlatbounce.build()
//
//
//                            val cameraUpdate = CameraUpdateFactory.newLatLngBounds(wowbounce,padding)
//                            mMap.moveCamera(cameraUpdate)
//                        }
//                    })



                }
            } catch (e: Exception) {
                Log.d(TAG, "yeah: $e")
            }
        }
    }



    fun startProcess() {
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

//        setCustomMarkerView()
//        getSampleMarkerItems()

        yeah(googleMap)

    }


    ////////////////////////////////


    private fun getSampleMarkerItems(){
        val latlngdata = arrayListOf<LatLngData>()

        latlngdata.add(LatLngData(1, LatLng(35.162339, 129.108509), "가"))
        latlngdata.add(LatLngData(2, LatLng(35.224836, 129.088285), "나"))
        latlngdata.add(LatLngData(3, LatLng(35.080117, 129.048376), "다"))

        for(i in latlngdata.indices){
            addMarker(latlngdata[i])
        }
    }

    private fun setCustomMarkerView(){
        marker_root_view = LayoutInflater.from(context).inflate(R.layout.marker_layout,null)
        tv_marker = marker_root_view.findViewById(R.id.tag_marker) as TextView
    }

    private fun addMarker(latLngData: LatLngData):Marker?{
        var markerOption = MarkerOptions()
        markerOption.position(latLngData.latlng).title("asdasd")
        tv_marker.setText(latLngData.tag)
        return mMap.addMarker(markerOption)
    }





}