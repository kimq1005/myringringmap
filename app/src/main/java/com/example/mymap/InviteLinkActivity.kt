package com.example.mymap

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase

class InviteLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite_link)

        checkInviteLink()
    }

    private fun checkInviteLink() {
        Firebase.dynamicLinks
            .getDynamicLink(intent)
            .addOnSuccessListener(this) { pendingDynamicLinkData ->
                // Get deep link from result (may be null if no link is found)
                var deepLink: Uri? = null
                if (pendingDynamicLinkData != null) {
                    deepLink = pendingDynamicLinkData.link
                }

                // 쿼리로 초대한 선생님의 uid가 존재한다면
                if (deepLink != null &&
                    deepLink.getBooleanQueryParameter("uid", false)
                ) {
                    /*
                    * 수업 리스트에 초대하는 로직
                    * */

                    val referrerUserId = deepLink.getQueryParameter("uid")
                    Toast.makeText(this, "$referrerUserId", Toast.LENGTH_SHORT).show()
                }
            }
    }
}