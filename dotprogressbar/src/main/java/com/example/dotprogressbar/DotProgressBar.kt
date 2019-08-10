package com.example.dotprogressbar

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.util.DisplayMetrics
import android.view.animation.LinearInterpolator

/**
 * Created by Sourabh Gupta on 9/8/19.
 */

class DotProgressBar : FrameLayout {
    private var margin = convertDpToPixel(4f)
    private var dotRadius = convertDpToPixel(8f)
    private var numberOfDots = 3
    private val animators = mutableListOf<Animator>()
    private val animationDuration = 1000
    private var minScale = 0.5f
    private var maxScale = 1f
    private var primaryAnimator: ValueAnimator? = null
    private lateinit var dotProgressBar: LinearLayout

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        dotProgressBar = LinearLayout(context)
        val progressBarLayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        progressBarLayoutParams.gravity = Gravity.CENTER
        dotProgressBar.layoutParams = progressBarLayoutParams
        addView(dotProgressBar)
        for (i in 0 until numberOfDots) {
            val dot = View(context)
            val layoutParams = LayoutParams(dotRadius * 2, dotRadius * 2)
            layoutParams.setMargins(margin, margin, margin, margin)
            dot.layoutParams = layoutParams
            dot.scaleX = minScale
            dot.scaleY = minScale
            dot.setBackgroundResource(R.drawable.ic_dot)
            dotProgressBar.addView(dot)
            val animator = getScaleAnimator(dot)
            animators.add(animator)
        }
        primaryAnimator?.cancel()
        primaryAnimator = ValueAnimator.ofInt(0, numberOfDots)
        primaryAnimator?.addUpdateListener {
            if (it.animatedValue != numberOfDots)
                animators[it.animatedValue as Int].start()
        }
        primaryAnimator?.repeatMode = ValueAnimator.RESTART
        primaryAnimator?.repeatCount = ValueAnimator.INFINITE
        primaryAnimator?.duration = animationDuration.toLong()
        primaryAnimator?.interpolator = LinearInterpolator()
        startAnimation()
    }

    private fun convertDpToPixel(dp: Float): Int {
        return (dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }

    private fun getScaleAnimator(view: View): Animator {
        val animator = ValueAnimator.ofFloat(minScale, maxScale)
        animator.addUpdateListener {
            view.scaleX = it.animatedValue as Float
            view.scaleY = it.animatedValue as Float
        }
        animator.duration = animationDuration / numberOfDots.toLong()
        animator.repeatCount = 1
        animator.repeatMode = ValueAnimator.REVERSE
        animator.interpolator = LinearInterpolator()
        return animator
    }

    fun stopAnimation() {
        primaryAnimator?.cancel()
    }

    fun startAnimation() {
        primaryAnimator?.start()
    }

    fun isAnimationRunning(): Boolean {
        return primaryAnimator!!.isRunning
    }

    fun setDotBackground(backgroundResource: Int) {
        for (childNumber in 0 until dotProgressBar.childCount)
            dotProgressBar.getChildAt(childNumber).setBackgroundResource(backgroundResource)
    }

    override fun setVisibility(visibility: Int) {
        if (visibility == View.VISIBLE) startAnimation()
        else stopAnimation()
        super.setVisibility(visibility)
    }
}