package com.elaine.lib_baserecyclerviewadapterhelper

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.elaine.lib_baserecyclerviewadapterhelper.animationpackage.AnimationActivity
import com.elaine.lib_baserecyclerviewadapterhelper.basequickadapterPackage.BaseQuickAdapterActivity
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ActivityMainBinding

/**
 * APP主入口
 */
class MainActivity : AppCompatActivity() {
    //布局
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //布局赋值
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initListener()
    }

    /**
     * 按钮监听事件
     */
    private fun initListener() {
        //基础使用---BaseQuickAdapter
        mBinding.btnBaseQuickAdapter.setOnClickListener {
            startActivity(Intent(this, BaseQuickAdapterActivity::class.java))
        }
        //动画效果
        mBinding.btnAnimation.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
    }
}