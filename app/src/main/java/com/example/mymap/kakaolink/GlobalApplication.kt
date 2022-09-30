package com.example.mymap.kakaolink

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {

    companion object{
        var instance : GlobalApplication? = null
    }


    override fun onCreate() {
        super.onCreate()
        instance = this

        KakaoSdk.init(this, "f1c2096c10969aa261655e2933769f2a")
    }
}