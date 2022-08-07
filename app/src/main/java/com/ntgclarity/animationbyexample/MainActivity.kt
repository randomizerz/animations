package com.ntgclarity.animationbyexample

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivFrames = findViewById<ImageView>(R.id.iv_frames)
        val btnAnimate = findViewById<Button>(R.id.btn_animate)

        val ani = ivFrames.background as AnimationDrawable

        btnAnimate.setOnClickListener {
            ani.stop()
            ani.start()
        }

        updateVisibility()

        translateY()

        launch()
    }

    private fun updateVisibility() {
        val btnShow = findViewById<Button>(R.id.btn_show)
        val btnHide = findViewById<Button>(R.id.btn_hide)
        val btnVisibility = findViewById<Button>(R.id.btn_visibility)

        btnShow.setOnClickListener { btnVisibility.visibility = View.VISIBLE }
        btnHide.setOnClickListener { btnVisibility.visibility = View.INVISIBLE }
    }

    private fun translateY() {
        val ivRocket = findViewById<ImageView>(R.id.iv_rocket)
        val btnTranslateY = findViewById<Button>(R.id.btn_translate_y)
        val dyAnimator = ObjectAnimator.ofFloat(ivRocket, "translationY", -100f)

        dyAnimator.duration = 500

        btnTranslateY.setOnClickListener { dyAnimator.start() }
    }

    private fun launch() {
        val ivRocketLaunch = findViewById<ImageView>(R.id.iv_rocket_launch)
        val btnLaunch = findViewById<Button>(R.id.btn_launch)

        val dyAnimator = ObjectAnimator.ofFloat(ivRocketLaunch, "translationY", -200f)
        val dxAnimator = ObjectAnimator.ofFloat(ivRocketLaunch, "translationX", 200f)

        val animator = AnimatorSet()

        animator.play(dyAnimator).after(dxAnimator)
        animator.duration = 300

        btnLaunch.setOnClickListener { animator.start() }
    }
}