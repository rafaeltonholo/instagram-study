package com.rtonholo.study.instagram.ui.view.custom

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager.widget.ViewPager

class CustomViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {
    constructor(context: Context) : this(context, null)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var heightMeasure = heightMeasureSpec
        val currentPagePosition = 0
        val child = getChildAt(currentPagePosition)
        if (child != null) {
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
            val childHeight = child.measuredHeight
            heightMeasure = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY)
        }
        super.onMeasure(widthMeasureSpec, heightMeasure)
    }
}