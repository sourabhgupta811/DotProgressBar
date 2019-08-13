package com.example.paytmprogressbar

import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dotprogressbar.DotProgressBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_second.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_second)
        val dotAnimator = ValueAnimator.ofFloat(0f,1f)
        dotAnimator.addUpdateListener{

        }
        val dotProgressBar = DotProgressBar.Builder()
            .setMargin(4)
            .setAnimationDuration(2000)
            .setDotBackground(R.drawable.ic_launcher_background)
            .setMaxScale(1f)
            .setMinScale(0.3f)
            .setNumberOfDots(5)
            .setdotRadius(8)
            .build(this)
        frame_layout.addView(dotProgressBar)
        dotProgressBar.startAnimation()
    }
}
