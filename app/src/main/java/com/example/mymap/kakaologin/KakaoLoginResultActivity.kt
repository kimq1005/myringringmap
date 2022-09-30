package com.example.mymap.kakaologin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymap.databinding.ActivityKaKaoResultBinding

class KakaoLoginResultActivity : AppCompatActivity() {
    private var kakaoresultbinding:ActivityKaKaoResultBinding?=null
    private val binding get() = kakaoresultbinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kakaoresultbinding = ActivityKaKaoResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}