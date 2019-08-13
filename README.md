# DotProgressBar
Dot progress Bar for Android

![](dot_progress_bar.gif)

How to use->
From XML
```
<com.example.dotprogressbar.DotProgressBar
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_gravity="center"
        android:id="@+id/dotProgressBar"
        android:layout_width="match_parent" android:layout_height="match_parent"/>
```
From Kotlin

```
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
```
