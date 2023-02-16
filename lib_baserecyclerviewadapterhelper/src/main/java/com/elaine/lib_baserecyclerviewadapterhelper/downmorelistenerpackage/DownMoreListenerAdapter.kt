package com.elaine.lib_baserecyclerviewadapterhelper.downmorelistenerpackage

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ItemDownMoreListenerBinding

/**
 * 下拉加载更多
 * 适配器
 */
class DownMoreListenerAdapter :
    BaseQuickAdapter<BaseBean?, BaseDataBindingHolder<ItemDownMoreListenerBinding>>(R.layout.item_down_more_listener),
    LoadMoreModule {
    override fun convert(
        holder: BaseDataBindingHolder<ItemDownMoreListenerBinding>,
        item: BaseBean?
    ) {
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
}