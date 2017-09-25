package com.jelletenbrinke.lib

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Created by Jelle on 25/09/2017.
 *
 * An interface to use for implementing scaling buttons for views.
 *
 */
interface IScalingView : View.OnTouchListener {

    fun loadAttributes(context: Context, attrs: AttributeSet)

    fun onActionDown()

    fun onActionUp()

    fun calculateScale(): Float

    fun scaleView(duration: Long, fromScale: Float, toScale: Float)

}