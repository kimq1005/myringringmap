package com.example.mymap.dynamiclink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mymap.ClassProgressActivity
import com.example.mymap.InviteLinkActivity
import com.example.mymap.R
import com.example.mymap.databinding.ActivityDynamicMainBinding
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase

class DynamicMainActivity : AppCompatActivity() {

    private var dynamicMainBinding: ActivityDynamicMainBinding? = null
    private val binding get() = dynamicMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dynamicMainBinding = ActivityDynamicMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findViewById<Button>(R.id.btnShareMain).setOnClickListener {
            DynamicLinkUtils.onDynamicLinkClick(
                this,
                SehemeActivity.SCHEME_PHEED,
                null
            )
        }

        findViewById<Button>(R.id.btnSharePheed1).setOnClickListener {
            DynamicLinkUtils.onDynamicLinkClick(
                this,
                SehemeActivity.SCHEME_PHEED,
                SehemeActivity.PARAM_ID,
                "1"
            )
        }

        findViewById<Button>(R.id.btnSharePheed2).setOnClickListener {
            DynamicLinkUtils.onDynamicLinkClick(
                this,
                SehemeActivity.SCHEME_PHEED,
                SehemeActivity.PARAM_ID,
                "2"
            )
        }

        findViewById<Button>(R.id.btnShareComment1).setOnClickListener {
            DynamicLinkUtils.onDynamicLinkClick(
                this,
                SehemeActivity.SCHEME_COMMENT,
                SehemeActivity.PARAM_ID,
                "1000"
            )
        }

        findViewById<Button>(R.id.btnShareComment2).setOnClickListener {
            DynamicLinkUtils.onDynamicLinkClick(
                this,
                SehemeActivity.SCHEME_COMMENT,
                SehemeActivity.PARAM_ID,
                "1001"
            )
        }

        binding.testdynamic.setOnClickListener {
            val intent = Intent(this, ClassProgressActivity::class.java)
            startActivity(intent)
        }


    }








}
