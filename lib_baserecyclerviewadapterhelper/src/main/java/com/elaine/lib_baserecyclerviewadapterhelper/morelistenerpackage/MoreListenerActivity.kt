package com.elaine.lib_baserecyclerviewadapterhelper.morelistenerpackage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ActivityMoreListenerBinding

/**
 * 顶部--向上加载
 */
class MoreListenerActivity : AppCompatActivity() {
    //布局
    private lateinit var mBinding: ActivityMoreListenerBinding

    //适配器
    private lateinit var moreListenerAdapter: MoreListenerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //布局赋值
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_more_listener)
        initAdapter()
    }

    /**
     * 初始化适配器
     */
    private fun initAdapter() {
        //构建适配器
        moreListenerAdapter = MoreListenerAdapter()
        mBinding.rvData.apply {
            //RecycleView设置layoutManager
            layoutManager = LinearLayoutManager(this@MoreListenerActivity)
            //RecycleView设置adapter
            adapter = moreListenerAdapter
        }
        //初始化数据
        moreListenerAdapter.setList(getData())

        //是否可以向上加载 true-是 false-否
        moreListenerAdapter.upFetchModule.isUpFetchEnable = true
        //向上加载监听 --增加数据
        moreListenerAdapter.upFetchModule.setOnUpFetchListener { addData() }
        //是否在向上加载中
        val isUpFetching = moreListenerAdapter.upFetchModule.isUpFetching
        Log.e("是否在向上加载中", "$isUpFetching")
        //启动位置,默认是1
        moreListenerAdapter.upFetchModule.startUpFetchPosition = 2

//        moreListenerAdapter.addUpFetchModule()
    }

    /**
     * 向上加载数据
     */
    private fun addData() {
        //是否在向上加载中 true--是
        moreListenerAdapter.upFetchModule.isUpFetching = true
        //延迟300添加数据，这里避免出现IllegalStateException: Cannot call this method while RecyclerView is computing a layout or scrolling
        mBinding.rvData.postDelayed({
            moreListenerAdapter.addData(0, getData())
        }, 300)
        //是否在向上加载中 false--否
        moreListenerAdapter.upFetchModule.isUpFetching = false
    }

    /**
     * 模拟数据
     */
    private fun getData(): List<BaseBean> {
        //构建数据
        val data: MutableList<BaseBean> = ArrayList()
        for (i in 0..20) {
            val baseBean = BaseBean()
            baseBean.content = "顶部--向上加载(MoreListener)---数据$i"
            data.add(baseBean)
        }
        return data
    }


}