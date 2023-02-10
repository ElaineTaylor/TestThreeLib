package com.elaine.lib_baserecyclerviewadapterhelper.itemlistenerpackage

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ActivityItemListenerBinding

/**
 * Item监听事件
 */
class ItemListenerActivity : AppCompatActivity() {
    //布局
    private lateinit var mBinding: ActivityItemListenerBinding

    //适配器
    private lateinit var itemListenerAdapter: ItemListenerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //布局赋值
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_item_listener)
        initAdapter()
        initData()
    }

    /**
     * 初始化适配器
     */
    private fun initAdapter() {
        //构建适配器
        itemListenerAdapter = ItemListenerAdapter()
        mBinding.rvData.apply {
            //RecycleView设置layoutManager
            layoutManager = LinearLayoutManager(this@ItemListenerActivity)
            //RecycleView设置adapter
            adapter = itemListenerAdapter
        }

        //点击事件
        itemListenerAdapter.setOnItemClickListener { adapter, view, position ->
//            val baseBean: BaseBean = adapter.data[position] as BaseBean
//            val viewId: Int = view.id
//            Toast.makeText(
//                this@ItemListenerActivity,
//                "item点击事件 内容${baseBean.content}｜ 位置 $position ｜ viewId $viewId",
//                Toast.LENGTH_SHORT
//            ).show()
        }
        //长按事件
        itemListenerAdapter.setOnItemLongClickListener { adapter, view, position ->
//            val baseBean: BaseBean = adapter.data[position] as BaseBean
//            val viewId: Int = view.id
//            Toast.makeText(
//                this@ItemListenerActivity,
//                "item长按事件 内容${baseBean.content}｜ 位置 $position ｜ viewId $viewId",
//                Toast.LENGTH_SHORT
//            ).show()
            true
        }
        //子控件点击事件添加子View的Id
        itemListenerAdapter.addChildClickViewIds(R.id.btn_inner)
        //子控件点击事件
        itemListenerAdapter.setOnItemChildClickListener { adapter, view, position ->
//            val baseBean: BaseBean = adapter.data[position] as BaseBean
//            val viewId: Int = view.id
//            Toast.makeText(
//                this@ItemListenerActivity,
//                "item子控件的点击事件 内容${baseBean.content}｜ 位置 $position ｜ viewId $viewId",
//                Toast.LENGTH_SHORT
//            ).show()
        }
        //子控件长按事件添加子View的Id
        itemListenerAdapter.addChildLongClickViewIds(R.id.btn_inner)
        //子控件长按事件
        itemListenerAdapter.setOnItemChildLongClickListener { adapter, view, position ->
//            val baseBean: BaseBean = adapter.data[position] as BaseBean
//            val viewId: Int = view.id
//            Toast.makeText(
//                this@ItemListenerActivity,
//                "item子控件的长按事件 内容${baseBean.content}｜ 位置 $position ｜ viewId $viewId",
//                Toast.LENGTH_SHORT
//            ).show()
            true
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
            baseBean.content = "Item监听(ItemListener)--数据$i"
            data.add(baseBean)
        }
        //适配器添加数据
        itemListenerAdapter.setList(data)
    }
}