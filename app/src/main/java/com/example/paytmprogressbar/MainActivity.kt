package com.example.paytmprogressbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start.setOnClickListener {
            if (dotProgressBar.isAnimationRunning())
                dotProgressBar.stopAnimation()
            else
                dotProgressBar.startAnimation()
        }
        Handler().postDelayed({
            dotProgressBar.setDotBackground(R.drawable.android)
        },3000)
    }
}
