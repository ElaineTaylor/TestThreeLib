package com.elaine.lib_baserecyclerviewadapterhelper.headfootemptypackage

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ActivityHeadFootEmptyBinding
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ItemFootBinding
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ItemHeadBinding

/**
 * 头部，底部，空布局
 */
class HeadFootEmptyActivity : AppCompatActivity() {

    //布局
    private lateinit var mBinding: ActivityHeadFootEmptyBinding

    //适配器
    private lateinit var headFootEmptyAdapter: HeadFootEmptyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //布局赋值
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_head_foot_empty)
        initListener()
        initAdapter()
        initData()
    }

    /**
     * 初始化适配器
     */
    private fun initAdapter() {
        //构建适配器
        headFootEmptyAdapter = HeadFootEmptyAdapter()
        //GridLayoutManager前提下，true则作为item的部分，false则作为adapter的头部
        headFootEmptyAdapter.headerViewAsFlow = false
        //GridLayoutManager前提下，true则作为item的部分，false则作为adapter的底部
        headFootEmptyAdapter.footerViewAsFlow = false
        mBinding.rvData.apply {
            //RecycleView设置layoutManager
//            layoutManager = GridLayoutManager(this@HeadFootEmptyActivity, 3)
            layoutManager = LinearLayoutManager(this@HeadFootEmptyActivity)
            //RecycleView设置adapter
            adapter = headFootEmptyAdapter
        }
    }

    /**
     * 填充数据
     */
    private fun initData() {
        //构建数据
        val data: MutableList<BaseBean> = ArrayList()
        for (i in 0..6) {
            val baseBean = BaseBean()
            baseBean.content = "头部，底部，空布局(HeadFootEmpty)---数据$i"
            data.add(baseBean)
        }
        //适配器添加数据
        headFootEmptyAdapter.setList(data)

        //替换头部
        val headerView = getHeadView()
        headList.add(headerView)
        headNum++
        headFootEmptyAdapter.setHeaderView(headerView)

        //替换底部
        val footerView = getFootView()
        footList.add(footerView)
        footNum++
        headFootEmptyAdapter.setFooterView(footerView)

        //如果有头部返回1，否则返回0
        val headerLayoutCount = headFootEmptyAdapter.headerLayoutCount
        Log.e("头部情况===", "$headerLayoutCount")

        //如果有底部返回1，否则返回0
        val footerLayoutCount = headFootEmptyAdapter.footerLayoutCount
        Log.e("底部情况===", "$footerLayoutCount")

        //是否有 HeaderLayout
        val isHasHeader = headFootEmptyAdapter.hasHeaderLayout()
        Log.e("是否有头部", "$isHasHeader")

        //是否有 hasFooterLayout
        val isHasFooter = headFootEmptyAdapter.hasFooterLayout()
        Log.e("是否有底部", "$isHasFooter")

        //是否使用空布局 true使用 false不使用
        headFootEmptyAdapter.isUseEmpty = true

    }

    private var headList: MutableList<View> = mutableListOf()
    private var headNum = 0
    private var footList: MutableList<View> = mutableListOf()
    private var footNum = 0

    /**
     * 初始化监听事件
     */
    private fun initListener() {
        //增加头部
        mBinding.btnHead.setOnClickListener {
            val view = getHeadView()
            headList.add(view)
            headNum++
            headFootEmptyAdapter.addHeaderView(view)
            //头部列表的指定位置插入，如果index的值小于头部列表的长度或者小于，则index值为头部列表的长度值
//            headFootEmptyAdapter.addHeaderView(view, 1)
        }
        //增加底部
        mBinding.btnFoot.setOnClickListener {
            val view = getFootView()
            footList.add(view)
            footNum++
            headFootEmptyAdapter.addFooterView(view)
            //底部列表的指定位置插入，如果index的值小于头部列表的长度或者小于，则index值为底部列表的长度值
//            headFootEmptyAdapter.addFooterView(view, 1)
        }
        //删除头部
        mBinding.btnHeadRemove.setOnClickListener {
            if (headList.size > 0 && headNum > 0) {
                headFootEmptyAdapter.removeHeaderView(headList[headNum - 1])
                headNum--
            }
        }
        //删除底部
        mBinding.btnFootRemove.setOnClickListener {
            if (footList.size > 0 && footNum > 0) {
                headFootEmptyAdapter.removeFooterView(footList[footNum - 1])
                footNum--
            }
        }
        //删除全部头部
        mBinding.btnHeadRemoveAll.setOnClickListener {
            headFootEmptyAdapter.removeAllHeaderView()
            headNum = 0
        }
        //删除全部底部
        mBinding.btnFootRemoveAll.setOnClickListener {
            headFootEmptyAdapter.removeAllFooterView()
            footNum = 0
        }
        //替换第一个头部
        mBinding.btnHeadSetIndexZero.setOnClickListener {
            val view = getHeadView()
            headFootEmptyAdapter.setHeaderView(view, 0)
        }
        //替换第一个底部
        mBinding.btnFootSetIndexZero.setOnClickListener {
            val view = getFootView()
            headFootEmptyAdapter.setFooterView(view, 0)
        }
        //        val headerPosition = headFootEmptyAdapter.headerViewPosition
//        Log.e("头部位置==", "$headerPosition")


        //设置空布局
        mBinding.btnEmpty.setOnClickListener {
            headFootEmptyAdapter.setList(null)
            //通过设置LayoutResId为空布局
            headFootEmptyAdapter.setEmptyView(R.layout.item_empty)
        }
        //设置带头空布局
        mBinding.btnEmptyWithHeader.setOnClickListener {

            //当显示空布局时，是否显示头部 true显示 false不显示
            headFootEmptyAdapter.headerWithEmptyEnable = true
            headFootEmptyAdapter.setList(null)
            //通过设置View为空布局
            headFootEmptyAdapter.setEmptyView(getEmptyView())
        }
        //设置带底空布局
        mBinding.btnEmptyWithFooter.setOnClickListener {
            //当显示空布局时，是否显示底部 true显示 false不显示
            headFootEmptyAdapter.footerWithEmptyEnable = true
            headFootEmptyAdapter.setList(null)
            //通过设置View为空布局
            headFootEmptyAdapter.setEmptyView(getEmptyView())
        }

        mBinding.btnEmptyRemove.setOnClickListener {
            //判断是否有空布局
            val isHasEmptyView = headFootEmptyAdapter.hasEmptyView()
            Log.e("是否有空布局==", "$isHasEmptyView")
            if (isHasEmptyView) {
                //删除空布局
                headFootEmptyAdapter.removeEmptyView()
            }
        }

    }

    /**
     * 获取头部
     */
    @SuppressLint("SetTextI18n")
    private fun getHeadView(): View {
        val binding: ItemHeadBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(this),
                R.layout.item_head,
                mBinding.rvData,
                false
            )
        binding.root.tag = ""
        binding.tvNum.text = "头部$headNum"
        return binding.root
    }

    /**
     * 获取底部
     */
    @SuppressLint("SetTextI18n")
    private fun getFootView(): View {
        val binding: ItemFootBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(this),
                R.layout.item_foot,
                mBinding.rvData,
                false
            )
        binding.tvNum.text = "底部$footNum"
        return binding.root
    }

    /**
     * 获取空布局
     */
    private fun getEmptyView(): View {
        return layoutInflater.inflate(R.layout.item_empty, mBinding.rvData, false)
    }

}