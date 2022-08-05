package com.example.mymap

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.mymap.Url.Companion.TAG
import com.example.mymap.databinding.ActivityMainBinding
import com.example.mymap.dynamiclink.DynamicMainActivity
import com.example.mymap.kakaolink.KaKaoMainActivity
import com.example.mymap.service.Retrofit_Manager
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import kotlinx.coroutines.*
import retrofit2.Retrofit
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private var mainbinding: ActivityMainBinding? = null
    private val binding get() = mainbinding!!

    var ischeck: Boolean = true

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        job = Job()


        binding.btnf.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framlayout, TestFragment())
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framlayout, MapsActivity())
                    .commit()
            }
        }

//        binding.dynamicBtn.setOnClickListener {
//            val intent = Intent(this, KaKaoMainActivity::class.java)
//            startActivity(intent)
//        }
//
//        binding.firebasebtn.setOnClickListener {
//            val intent = Intent(this, DynamicMainActivity::class.java)
//            startActivity(intent)
//        }

    }

    override fun onStart() {
        super.onStart()
        startPermissionRequest()
    }

    private fun startPermissionRequest() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CALL_PHONE
            ),
            34
        )
    }



}