package com.example.mymap

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mymap.Url.Companion.TAG
import com.example.mymap.databinding.ActivityClassProgressBinding
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks

class ClassProgressActivity : AppCompatActivity() {

    private var classbinding:ActivityClassProgressBinding? =null
    private val binding get() = classbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        classbinding = ActivityClassProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tetsbnt.setOnClickListener {
//            invite()
            kakaoTalk()
        }
    }

    fun kakaoTalk(){
        val message = "보낼 내용"
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, message)
        intent.setPackage("com.kakao.talk")
        startActivity(intent)
    }

    private fun sendInviteLink(inviteLink: Uri) {
        val teacherName = "김승현"
        val inviteIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
//            type = ("vnd.android-dir/mms-sms")
            setPackage("com.kakao.talk")

            putExtra(
                Intent.EXTRA_TEXT,
                "$teacherName !\n  : $inviteLink"
            )
        }

        try {
            startActivity(inviteIntent) // 수업 초대를 위해 카카오톡 실행
        } catch (e: ActivityNotFoundException) {
            // 카카오톡이 설치되어 있지 않은 경우 예외 발생
            Log.d(TAG, "sendInviteLink: $e")
        }
    }

    private fun invite() {
        val userId = "123154151525346dssdfszdf" // Query로 사용할 유저 아이디 (Uid로 변경 가능성)

        // (Manifest에 설정한 scheme, host, path와 동일해야 함.)
        val invitationLink = "https://ringtestservice.page.link/invite?uid=$userId" // 생성할 다이나믹 링크

        val dynamicLink =
            FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse(invitationLink))
                .setDomainUriPrefix("https://ringtestservice.page.link") // 파이어베이스 다이나믹 링크란에 설정한 Prefix 입력
                .setAndroidParameters(
                    DynamicLink.AndroidParameters
                        .Builder()
                        .setMinimumVersion(1)
                        .build()
                )
                .buildShortDynamicLink()


        dynamicLink.addOnSuccessListener { task ->
            val inviteLink = task.shortLink!!
            sendInviteLink(inviteLink)
        }

    }


}