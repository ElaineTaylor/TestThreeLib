package com.elaine.lib_baserecyclerviewadapterhelper

import android.app.Application
import com.chad.library.adapter.base.module.LoadMoreModuleConfig
import com.elaine.lib_baserecyclerviewadapterhelper.downmorelistenerpackage.CustomDownMoreView

class LibApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initCustomDownMoreView()
    }

    /**
     * 初始化自定义底部--加载更多视图
     * 全局通用
     */
    private fun initCustomDownMoreView() {
        LoadMoreModuleConfig.defLoadMoreView = CustomDownMoreView()
    }
}