package com.example.mymap.util

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.mymap.Url.Companion.TAG

class MyUtill {

    companion object{
        val myutil = MyUtill()
    }

    fun toastMesasge(view:View, context: Context,text: String){
        view.setOnClickListener {
            Toast.makeText(context , text,Toast.LENGTH_SHORT).show()
        }
    }


    
}