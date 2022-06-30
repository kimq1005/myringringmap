package com.example.mymap.kakaolink

import android.content.Context
import android.util.Log
import com.kakao.sdk.link.LinkClient
import com.kakao.sdk.template.model.Content
import com.kakao.sdk.template.model.FeedTemplate
import com.kakao.sdk.template.model.Link

class KaKaoLink {


    fun kakaoLink(context : Context) {

        val defaultFeed = FeedTemplate(
            content = Content(
                title = "타이틀",
                description = "메시지 내용",
                imageUrl = "이미지 경로",
                link = Link(
                    webUrl = "웹 링크",
                    mobileWebUrl = "모바일 링크"


                )
            )
        )
        LinkClient.instance.defaultTemplate(context, defaultFeed) { linkResult, error ->
            if (error != null) {
                Log.e("TAG", "카카오링크 보내기 실패", error)
            }
            else if (linkResult != null) {
                context.startActivity(linkResult.intent)

                // 카카오링크 보내기에 성공했지만 아래 경고 메시지가 존재할 경우 일부 컨텐츠가 정상 동작하지 않을 수 있습니다.
                Log.w("TAG", "Warning Msg: ${linkResult.warningMsg}")
                Log.w("TAG", "Argument Msg: ${linkResult.argumentMsg}")
            }
        }
    }
}