package com.elaine.lib_baserecyclerviewadapterhelper.itemlistenerpackage

import android.view.View
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ItemItemListenerBinding

/**
 * Item监听事件--适配器
 */
class ItemListenerAdapter :
    BaseQuickAdapter<BaseBean?, BaseDataBindingHolder<ItemItemListenerBinding>>(R.layout.item_item_listener) {
    override fun convert(
        holder: BaseDataBindingHolder<ItemItemListenerBinding>,
        item: BaseBean?
    ) {
        addChildClickViewIds()
        val mBinding = holder.dataBinding
        if (mBinding != null) {
            //赋值实体
            if (item != null) {
                mBinding.bean = item
            }
            //更新内容
            mBinding.executePendingBindings()
        }
    }

    /**
     * 如果你想重新实现 item 点击事件逻辑，请重写此方法
     */
    override fun setOnItemClick(v: View, position: Int) {
        Toast.makeText(context, "点击事件", Toast.LENGTH_SHORT).show()
    }

    /**
     * 如果你想重新实现 item 长按事件逻辑，请重写此方法
     */
    override fun setOnItemLongClick(v: View, position: Int): Boolean {
        Toast.makeText(context, "长按事件", Toast.LENGTH_SHORT).show()
        return true
    }

    /**
     * 如果你想重新实现 item  子控件点击事件逻辑，请重写此方法
     */
    override fun setOnItemChildClick(v: View, position: Int) {
        Toast.makeText(context, "子控件点击事件", Toast.LENGTH_SHORT).show()
    }

    /**
     * 如果你想重新实现 item  子控件长按事件逻辑，请重写此方法
     */
    override fun setOnItemChildLongClick(v: View, position: Int): Boolean {
        Toast.makeText(context, "子控件长按事件", Toast.LENGTH_SHORT).show()
        return true
    }


}