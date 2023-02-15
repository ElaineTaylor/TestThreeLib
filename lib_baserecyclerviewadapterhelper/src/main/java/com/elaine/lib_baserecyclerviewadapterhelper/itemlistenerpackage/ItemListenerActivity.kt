package com.elaine.lib_baserecyclerviewadapterhelper.itemlistenerpackage

import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.listener.OnItemDragListener
import com.chad.library.adapter.base.listener.OnItemSwipeListener
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

        //是否可以拖拽 true--是，false--否
        itemListenerAdapter.draggableModule.isDragEnabled = true
        //长按拖拽的目标组件ID
        itemListenerAdapter.draggableModule.toggleViewId = R.id.btn_inner
        //判断是否有目标组件
        val isHasToggleView = itemListenerAdapter.draggableModule.hasToggleView()
        Log.e("是否有目标组件==", "$isHasToggleView")//true
        //是否可以长按拖动 配合toggleViewId使用
        itemListenerAdapter.draggableModule.isDragOnLongPressEnabled = true

        //拖拽监听事件
        itemListenerAdapter.draggableModule.setOnItemDragListener(object : OnItemDragListener {
            //拖拽开始
            override fun onItemDragStart(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                Log.e("拖拽===", "onItemDragStart")
            }

            //拖拽中
            override fun onItemDragMoving(
                source: RecyclerView.ViewHolder?,
                from: Int,
                target: RecyclerView.ViewHolder?,
                to: Int
            ) {
                Log.e("拖拽===", "onItemDragMoving")
            }

            //拖拽结束
            override fun onItemDragEnd(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                Log.e("拖拽===", "onItemDragEnd")
            }
        })


        //是否可以滑动  true--是，false--否
        itemListenerAdapter.draggableModule.isSwipeEnabled = true
        //设置滑动运动方向
        itemListenerAdapter.draggableModule.itemTouchHelperCallback.setSwipeMoveFlags(
            //前滑或者后滑
            ItemTouchHelper.START or ItemTouchHelper.END
        )
        //滑动监听事件
        itemListenerAdapter.draggableModule.setOnItemSwipeListener(object : OnItemSwipeListener {
            //滑动开始
            override fun onItemSwipeStart(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                Log.e("滑动===", "onItemSwipeStart")
            }

            //清除View
            override fun clearView(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                Log.e("滑动===", "clearView")
            }

            //滑动了
            override fun onItemSwiped(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                Log.e("滑动===", "onItemSwiped")
            }

            //滑动中
            override fun onItemSwipeMoving(
                canvas: Canvas?,
                viewHolder: RecyclerView.ViewHolder?,
                dX: Float,
                dY: Float,
                isCurrentlyActive: Boolean
            ) {
                Log.e("滑动===", "onItemSwipeMoving")
            }
        })

//        itemListenerAdapter.draggableModule.attachToRecyclerView()
//        itemListenerAdapter.draggableModule.itemTouchHelperCallback
//        itemListenerAdapter.draggableModule.itemTouchHelper
//        itemListenerAdapter.addDraggableModule()
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