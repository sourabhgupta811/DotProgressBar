package com.example.paytmprogressbar

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
        val builder = DotProgressBar.Builder()
        frame_layout
    }
}
