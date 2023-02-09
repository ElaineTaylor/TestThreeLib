package com.elaine.lib_baserecyclerviewadapterhelper.animationpackage

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.DecelerateInterpolator
import com.chad.library.adapter.base.animation.BaseAnimation

/**
 * 官方demo提供的自定义动画
 * X轴和Y轴从1.3f到1f
 * 同时透明度从0f到1f
 */
class CustomAnimation : BaseAnimation {
    override fun animators(view: View): Array<Animator> {
        //动画
        val scaleY: Animator = ObjectAnimator.ofFloat(view, "scaleY", 1.3f, 1f)
        val scaleX: Animator = ObjectAnimator.ofFloat(view, "scaleX", 1.3f, 1f)
        val alpha: Animator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        //过度时间
        scaleY.duration = 350
        scaleX.duration = 350
        alpha.duration = 350
        //设置插值器
        scaleY.interpolator = DecelerateInterpolator()
        scaleX.interpolator = DecelerateInterpolator()
        return arrayOf(scaleY, scaleX, alpha)
    }
}