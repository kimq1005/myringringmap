package com.example.mymap.kakaolink

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mymap.MainActivity
import com.example.mymap.Url
import com.example.mymap.databinding.ActivityKaKaoResultBinding
import com.example.mymap.dynamiclink.SehemeActivity
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase

class KaKaoResultActivity : AppCompatActivity() {

    private var kakaoResultbindg : ActivityKaKaoResultBinding ?=null
    private val binding get() = kakaoResultbindg!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kakaoResultbindg = ActivityKaKaoResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleDynamicLinks()


    }

    fun handleDynamicLinks(){
        Firebase.dynamicLinks
            .getDynamicLink(intent)
            .addOnSuccessListener(this){ pendingDynamicLinkData->
                var deeplink: Uri?=null
                if(pendingDynamicLinkData !=null){
                    deeplink = pendingDynamicLinkData.link
                }

                if(deeplink !=null){
                    val segment: String = deeplink.lastPathSegment!!
                    when(segment){
                        SehemeActivity.SCHEME_PHEED ->{
                            val code:String = deeplink.getQueryParameter(SehemeActivity.PARAM_ID)!!
                            Toast.makeText(this, "무야호: $code 데이터 보여주기", Toast.LENGTH_SHORT).show()
                            binding.kaakoResultTextView.text = code
                            val intent = Intent(this, KaKaoResultActivity::class.java)
                            startActivity(intent)
                        }

                        SehemeActivity.SCHEME_COMMENT -> {
                            //공유 타입이 comment로 들어왔을 때 처리
                            val code: String = deeplink.getQueryParameter(SehemeActivity.PARAM_ID)!!
                            Toast.makeText(this, "SCHEME_COMMENT 타입 id : $code 데이터 보여주기", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, KaKaoResultActivity::class.java)
                            startActivity(intent)
                        }

                        SehemeActivity.SCHEME_MAIN -> {
                            //공유 타입이 main으로 들어왔을 때 처리
                            Toast.makeText(this, "메인 이동", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, KaKaoResultActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }else{
                    Log.d(Url.TAG, "handleDynamicLinks: 에러다")
                }
            } .addOnFailureListener(this) { e -> Log.e(Url.TAG, "getDynamicLink:onFailure", e) }
    }
}