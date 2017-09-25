package com.jelletenbrinke.lib

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.LinearLayout

/**
 * Created by Jelle on 25/09/2017.
 */
class ScalingLinearLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs), IScalingView {


    private var scalePx: Float = 0.0f;

    init {
        loadAttributes(context, attrs)

        setOnTouchListener(this)
    }

    override fun loadAttributes(context: Context, attrs: AttributeSet) {
        val attributeArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.ScalingView)

        scalePx = attributeArray.getDimensionPixelSize(R.styleable.ScalingView_scaleDp, 0).toFloat()
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) onActionDown()
        else if (event.action == MotionEvent.ACTION_UP) onActionUp()

        return false;
    }

    override fun onActionDown() {
        var scale = calculateScale()

        scaleView(100, 1f, scale)
    }

    override fun onActionUp() {
        var scale = calculateScale()

        scaleView(300, scale, 1f)
    }

    override fun calculateScale(): Float {
        if (width > height) return (width - scalePx) / width
        else return (height - scalePx) / height
    }

    override fun scaleView(duration: Long, fromScale: Float, toScale: Float) {
        val anim = ScaleAnimation(fromScale, toScale, fromScale, toScale, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        anim.fillAfter = true // Needed to keep the result of the animation
        anim.duration = duration

        startAnimation(anim)
    }


}