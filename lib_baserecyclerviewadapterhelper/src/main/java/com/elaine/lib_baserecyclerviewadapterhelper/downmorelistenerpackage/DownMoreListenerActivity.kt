package com.elaine.lib_baserecyclerviewadapterhelper.downmorelistenerpackage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ActivityDownMoreListenerBinding

/**
 * 底部--加载更多
 */
class DownMoreListenerActivity : AppCompatActivity() {
    //布局
    private lateinit var mBinding: ActivityDownMoreListenerBinding

    //适配器
    private lateinit var downMoreListenerAdapter: DownMoreListenerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //布局赋值
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_down_more_listener)
        initAdapter()
        initData()
    }

    /**
     * 初始化适配器
     */
    private fun initAdapter() {
        //构建适配器
        downMoreListenerAdapter = DownMoreListenerAdapter()
        mBinding.rvData.apply {
            //RecycleView设置layoutManager
            layoutManager = LinearLayoutManager(this@DownMoreListenerActivity)
            //RecycleView设置adapter
            adapter = downMoreListenerAdapter
        }

        //是否打开加载更多 true-是 false-否
        downMoreListenerAdapter.loadMoreModule.isEnableLoadMore = true
        //设置加载监听事件
        downMoreListenerAdapter.loadMoreModule.setOnLoadMoreListener { addData() }
        //是否打开自动加载更多 true-是 false-否
        downMoreListenerAdapter.loadMoreModule.isAutoLoadMore = true
        //当自动加载isAutoLoadMore开启，同时数据不满一屏时，是否继续执行自动加载更多
        downMoreListenerAdapter.loadMoreModule.isEnableLoadMoreIfNotFullPage = true
        //所有数据加载完成后是否允许点击 true-是 false-否
        downMoreListenerAdapter.loadMoreModule.enableLoadMoreEndClick = true
        //是否加载中
        val isLoading = downMoreListenerAdapter.loadMoreModule.isLoading
        Log.e("是否加载中===", "$isLoading")
        //预加载的位置（默认为1）
        downMoreListenerAdapter.loadMoreModule.preLoadNumber = 2

        //是否有加载中视图
        val isHas = downMoreListenerAdapter.loadMoreModule.hasLoadMoreView()
        Log.e("是否有加载中视图===", "$isHas")
        //可以加载更多的位置
        val position = downMoreListenerAdapter.loadMoreModule.loadMoreViewPosition
        Log.e("可以加载更多的位置===", "$position")
        //用来检查数据是否满一屏
        val isCheck = downMoreListenerAdapter.loadMoreModule.checkDisableLoadMoreIfNotFullPage()
        Log.e("用来检查数据是否满一屏===", "$isCheck")
        //设置加载更多布局--自定义布局
//        downMoreListenerAdapter.loadMoreModule.loadMoreView

//        downMoreListenerAdapter.loadMoreModule.isLoadEndMoreGone
//        downMoreListenerAdapter.loadMoreModule.loadMoreStatus
//        downMoreListenerAdapter.addLoadMoreModule()



    }

    /**
     * 添加数据
     */
    private fun addData() {
        //状态手动置为“加载中”，并且会调用加载更多监听  一般情况下，不需要自己设置'加载中'状态
//        downMoreListenerAdapter.loadMoreModule.loadMoreToLoading()

        //构建数据
        val data: MutableList<BaseBean> = ArrayList()
        for (i in 20..40) {
            val baseBean = BaseBean()
            baseBean.content = "下拉加载更多(DownMore)---数据$i"
            data.add(baseBean)
        }
        //适配器添加数据
        downMoreListenerAdapter.addData(data)
        //本次数据加载完毕
        downMoreListenerAdapter.loadMoreModule.loadMoreComplete()
        //本次数据加载错误
//        downMoreListenerAdapter.loadMoreModule.loadMoreFail()
        //所有数据加载完成
//        downMoreListenerAdapter.loadMoreModule.loadMoreEnd(true)
    }

    /**
     * 填充数据
     */
    private fun initData() {
        //构建数据
        val data: MutableList<BaseBean> = ArrayList()
        for (i in 0..20) {
            val baseBean = BaseBean()
            baseBean.content = "下拉加载更多(DownMore)---数据$i"
            data.add(baseBean)
        }
        //适配器添加数据
        downMoreListenerAdapter.setList(data)
    }
}