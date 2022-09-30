package com.example.mymap


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.tooling.preview.Preview


import com.example.mymap.databinding.ActivityBarchartBinding
import java.lang.reflect.Modifier

class BarchartActivity : AppCompatActivity() {

    private var barchartBinding: ActivityBarchartBinding? = null
    private val binding get() = barchartBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        barchartBinding = ActivityBarchartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.testbtn.setOnClickListener {
            (binding.orangeLineFiveStars.layoutParams as LinearLayout.LayoutParams).weight = 5F
            (binding.whiteLineFiveStars.layoutParams as LinearLayout.LayoutParams).weight = 5F

            binding.parentLinearLayout.requestLayout()
        }


    }


}