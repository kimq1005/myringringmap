package com.example.mymap.dynamiclink

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.example.mymap.Url
import com.example.mymap.Url.Companion.TAG
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks

object DynamicLinkUtils {


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
    ) {
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

                val shortLink: Uri = task.result.shortLink!!
                if (task.isSuccessful) {
                    val shortLink: Uri = task.result.shortLink!!

                    try {

                        val sendIntent = Intent()
                        sendIntent.apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, shortLink.toString())
                            type = "test/plain"

                            activity.startActivity(Intent.createChooser(sendIntent, "Share"))
                        }

                        Log.d(TAG, "onDynamicLinkClick: $shortLink")
                    } catch (ignored: ActivityNotFoundException) {

                    }


                } else {
                    Log.d(Url.TAG, "onDynamicLinkClick: ${task.toString()}")
                }
            }




    }
}