package com.example.mymap.kakaolink

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mymap.Url
import com.example.mymap.Url.Companion.TAG
import com.example.mymap.databinding.ActivityKaKaoMainBinding
import com.example.mymap.dynamiclink.DynamicLinkUtils
import com.example.mymap.dynamiclink.SehemeActivity
import com.example.mymap.dynamiclink.SehemeActivity.Companion.SCHEME_PHEED
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.kakao.sdk.common.util.KakaoCustomTabsClient
import com.kakao.sdk.link.LinkClient
import com.kakao.sdk.link.WebSharerClient
import com.kakao.sdk.template.model.*

class KaKaoMainActivity : AppCompatActivity() {

    private var kaKaoMainBinding: ActivityKaKaoMainBinding? = null
    private val binding get() = kaKaoMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kaKaoMainBinding = ActivityKaKaoMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.kakaolinkbtn.setOnClickListener {
            onDynamicLinkClick(this,
                SehemeActivity.SCHEME_PHEED,
                SehemeActivity.PARAM_ID,
                "1")
        }


    }



    private fun sendKakaoLink(uri:Uri) {
        // 메시지 템플릿 만들기 (피드형)

        val title:String =" "
        val descripotion : String =" "
        val defaultFeed = FeedTemplate(

            content = Content(
                title = uri.toString(),
                description = "dasdasdasd",
                imageUrl = " userReview.review.image",
                link = Link(
                    mobileWebUrl = "https://play.google.com/store/apps/details?id=com.mtjin.nomoneytrip"
                )
            ),
            social = Social(
                likeCount = 2
            )

        )

        // 피드 메시지 보내기
        LinkClient.instance.defaultTemplate(this, defaultFeed) { linkResult, error ->
            if (error != null) {
                Log.e(TAG, "카카오링크 보내기 실패", error)
            }
            else if (linkResult != null) {
                Log.d(TAG, "카카오링크 보내기 성공 ${linkResult.intent}")
                startActivity(linkResult.intent)

                // 카카오링크 보내기에 성공했지만 아래 경고 메시지가 존재할 경우 일부 컨텐츠가 정상 동작하지 않을 수 있습니다.
                Log.w(TAG, "Warning Msg: ${linkResult.warningMsg}")
                Log.w(TAG, "Argument Msg: ${linkResult.argumentMsg}")
            }
        }

        //메시지 보내기 (뒤에서 살펴볼것)
    }

    private fun getDeepLink(scheme: String, key: String?, id: String?): Uri {
        return if (key == null) {
            Uri.parse("https://testring.com/${scheme}")
        } else {
            Uri.parse("https://testring.com/${scheme}/?${key}=$id")
        }
    }

    fun onDynamicLinkClick(
        activity: Activity,
        scheme: String,
        key: String? = null,
        id: String? = null,
    ){
        FirebaseDynamicLinks.getInstance().createDynamicLink()
            .setLink(getDeepLink(scheme, key, id))
            .setDynamicLinkDomain("ringringtestdomain.page.link")
            .setAndroidParameters(
                DynamicLink.AndroidParameters.Builder(activity.packageName)
                    .setMinimumVersion(1)
                    .build()
            )

            .buildShortDynamicLink()
            .addOnCompleteListener(activity) { task ->


                if (task.isSuccessful) {
                    val shortLink: Uri = task.result.shortLink!!

                    try {

                        sendKakaoLink(shortLink)
                        Log.d(TAG, "onDynamicLinkClick: $shortLink")
                    } catch (ignored: ActivityNotFoundException) {
                        Log.d(TAG, "onDynamicLinkClick: $ignored")
                    }


                } else {
                    Log.d(Url.TAG, "onDynamicLinkClick: ${task.toString()}")
                }
            }




    }


}