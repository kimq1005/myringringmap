package com.example.mymap.dynamiclink

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mymap.MainActivity
import com.example.mymap.Url
import com.example.mymap.Url.Companion.TAG
import com.example.mymap.databinding.ActivitySehemeBinding
import com.example.mymap.kakaolink.KaKaoResultActivity
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase

class SehemeActivity : AppCompatActivity() {

    companion object{
        val SCHEME_PHEED = "pheed"
        val SCHEME_MAIN = "main"
        val SCHEME_COMMENT = "comment"

        val KAKAO_PEED = "kakao"

        val PARAM_ID = "id"
    }

    private var sehemeBinding:ActivitySehemeBinding?=null
    private val binding get() = sehemeBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sehemeBinding = ActivitySehemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleDynamicLinks()

    }




    fun handleDynamicLinks(){
        Firebase.dynamicLinks
            .getDynamicLink(intent)
            .addOnSuccessListener(this){ pendingDynamicLinkData->
                var deeplink:Uri?=null
                if(pendingDynamicLinkData !=null){
                    deeplink = pendingDynamicLinkData.link
                }

                if(deeplink !=null){
                    val segment: String = deeplink.lastPathSegment!!
                    when(segment){
                        SCHEME_PHEED->{
                            val code:String = deeplink.getQueryParameter(KAKAO_PEED)!!
                            Toast.makeText(this, "SCHEME_PHEED 타입 id : $code 데이터 보여주기",Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@SehemeActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                        SCHEME_COMMENT -> {
                            //공유 타입이 comment로 들어왔을 때 처리
                            val code: String = deeplink.getQueryParameter(PARAM_ID)!!
                            Toast.makeText(this, "SCHEME_COMMENT 타입 id : $code 데이터 보여주기", Toast.LENGTH_LONG).show()
                            val intent = Intent(this@SehemeActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                        SCHEME_MAIN -> {
                            //공유 타입이 main으로 들어왔을 때 처리
                            Toast.makeText(this, "메인 이동", Toast.LENGTH_LONG).show()
                            val intent = Intent(this@SehemeActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }else{
                    Log.d(TAG, "handleDynamicLinks: 에러다")
                }
            } .addOnFailureListener(this) { e -> Log.e(TAG, "getDynamicLink:onFailure", e) }
    }
}