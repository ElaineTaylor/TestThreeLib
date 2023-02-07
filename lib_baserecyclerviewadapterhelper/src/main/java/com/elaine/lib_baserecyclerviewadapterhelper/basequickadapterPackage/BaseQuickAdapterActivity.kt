package com.elaine.lib_baserecyclerviewadapterhelper.basequickadapterPackage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ActivityBaseQuickAdapterBinding

/**
 * 基础使用--BaseQuickAdapter
 */
class BaseQuickAdapterActivity : AppCompatActivity() {
    //布局
    private lateinit var mBinding: ActivityBaseQuickAdapterBinding

    //适配器
    private lateinit var baseQuickAdapterAdapter: BaseQuickAdapterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //布局赋值
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_base_quick_adapter)
        initAdapter()
        initData()
    }

    /**
     * 初始化适配器
     */
    private fun initAdapter() {
        //构建适配器
        baseQuickAdapterAdapter = BaseQuickAdapterAdapter()
        mBinding.rvData.apply {
            //RecycleView设置layoutManager
            layoutManager = LinearLayoutManager(this@BaseQuickAdapterActivity)
            //RecycleView设置adapter
            adapter = baseQuickAdapterAdapter
        }
    }

    /**
     * 填充数据
     */
    private fun initData() {
        //构建数据
        val data: MutableList<BaseBean> = ArrayList()
        for (i in 0..20) {
            val baseBean = BaseBean()
            baseBean.content = "基础使用(BaseQuickAdapter)---数据$i"
            data.add(baseBean)
        }
        //适配器添加数据
        baseQuickAdapterAdapter.setList(data)
    }
}