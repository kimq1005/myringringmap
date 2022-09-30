package com.example.mymap

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.mymap.Url.Companion.TAG
import com.example.mymap.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.kakao.sdk.common.util.Utility
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
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

        val keyHash = Utility.getKeyHash(this)
        Log.d(TAG, "onCreate: $keyHash")

        job = Job()


        binding.btnf.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framlayout, TestFragment())
                    .commit()
                binding.btnf.background = ContextCompat.getDrawable(this, R.color.black)
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framlayout, MapsActivity())
                    .commit()

                binding.btnf.background = ContextCompat.getDrawable(this, R.color.white)
            }
        }

        binding.gogobtn.setOnClickListener {
            val intent = Intent(this, BarchartActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.testman.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }




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

    private fun wow(){

    }




}