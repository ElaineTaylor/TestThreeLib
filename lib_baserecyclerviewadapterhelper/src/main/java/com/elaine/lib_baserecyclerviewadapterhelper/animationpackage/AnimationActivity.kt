package com.elaine.lib_baserecyclerviewadapterhelper.animationpackage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ActivityAnimationBinding

/**
 * 动画效果
 */
class AnimationActivity : AppCompatActivity() {
    //布局
    private lateinit var mBinding: ActivityAnimationBinding

    //适配器
    private lateinit var animationAdapter: AnimationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //布局赋值
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_animation)
        initAdapter()
        initData()
    }

    /**
     * 初始化适配器
     */
    private fun initAdapter() {
        //构建适配器
        animationAdapter = AnimationAdapter()
        //默认动画效果 AlphaIn（透明度进入）, ScaleIn（缩放进入）, SlideInBottom（从底部进入）, SlideInLeft（从左侧进入）, SlideInRight（从右侧进入）
        animationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.AlphaIn)
        //自定义动画效果
//        animationAdapter.adapterAnimation = CustomAnimation()
        //动画是否执行一次 false--上下滑动都会执行动画；true--出现过的item不再执行动画
        animationAdapter.isAnimationFirstOnly = false
        //是否有动画效果 true--是；false--否
        animationAdapter.animationEnable = true
        mBinding.rvData.apply {
            //RecycleView设置layoutManager
            layoutManager = LinearLayoutManager(this@AnimationActivity)
            //RecycleView设置adapter
            adapter = animationAdapter
        }
    }

    /**
     * 填充数据
     */
    private fun initData() {
        //构建数据
        val data: MutableList<BaseBean> = ArrayList()
        for (i in 0..50) {
            val baseBean = BaseBean()
            baseBean.content = "动画效果(AnimationActivity)---数据$i"
            data.add(baseBean)
        }
        //适配器添加数据
        animationAdapter.setList(data)
    }
}