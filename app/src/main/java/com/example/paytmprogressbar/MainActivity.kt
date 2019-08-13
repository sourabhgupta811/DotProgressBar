package com.example.paytmprogressbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dotprogressbar.DotProgressBar
import kotlinx.android.synthetic.main.activity_main_second.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_second)
        val dotProgressBar = DotProgressBar.Builder()
            .setMargin(1)
            .setAnimationDuration(1000)
            .setDotBackground(R.drawable.ic_dot)
            .setMaxScale(1f)
            .setMinScale(0.3f)
            .setNumberOfDots(5)
            .setdotRadius(16)
            .build(this)
        frame_layout.addView(dotProgressBar)
        dotProgressBar.startAnimation()
    }
}
