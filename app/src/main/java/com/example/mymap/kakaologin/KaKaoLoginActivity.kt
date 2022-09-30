package com.example.mymap.kakaologin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mymap.Url.Companion.TAG
import com.example.mymap.databinding.ActivityKaKaoLoginBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient

class KaKaoLoginActivity : AppCompatActivity() {
    private var kakaobinding :ActivityKaKaoLoginBinding?=null
    private val binding get() = kakaobinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        kakaobinding = ActivityKaKaoLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
//            if(error!=null){
//                toast(this, "토큰 정보 보기 실패")
//            }
//            else if(tokenInfo!=null){
//                toast(this,"토큰 정보 보기 성공")
//                val intent = Intent(this, KakaoLoginResultActivity::class.java)
//                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//                finish()
//            }
//        }
//        val callback : (OAuthToken?, Throwable?)->Unit = { token, error->
//            if(error != null){
//                when {
//                    error.toString() == AuthErrorCause.AccessDenied.toString()->{
//                        toast(this,"접근이 거부 됨(동의 취소)")
//                    }
//                    error.toString() == AuthErrorCause.InvalidClient.toString()->{
//                        toast(this,"유효하지 않은 앱")
//                    }
//                    error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
//                        Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
//                        Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.InvalidScope.toString() -> {
//                        Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.Misconfigured.toString() -> {
//                        Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.ServerError.toString() -> {
//                        Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.Unauthorized.toString() -> {
//                        Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
//                    }
//                    else -> { // Unknown
//                        Toast.makeText(this, "기타 에러 $error", Toast.LENGTH_SHORT).show()
//                        Log.d(TAG, "기타 에러 $error ")
//                    }
//
//                }
//            }
//
//            else if(token!=null){
//                toast(this, "로그인에 성공 하였습니다.")
//                val intent = Intent(this, KakaoLoginResultActivity::class.java)
//                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//                finish()
//            }
//        }
//
//        binding.kakaoLoginButton.setOnClickListener {
//           if(UserApiClient.instance.isKakaoTalkLoginAvailable(this)){
//               UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
//           }else{
//               UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
//           }
//        }

    }


    private fun toast(context: Context,text:String){
        Toast.makeText(context, text,Toast.LENGTH_SHORT).show()
    }
}