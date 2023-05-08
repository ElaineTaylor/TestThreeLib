package com.elaine.lib_baserecyclerviewadapterhelper.headfootemptypackage

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ItemHeadFootEmptyAdapterBinding

/**
 * 头部，底部，空布局使用--HeadFootEmptyAdapter
 * 适配器
 */
class HeadFootEmptyAdapter :
    BaseQuickAdapter<BaseBean?, BaseDataBindingHolder<ItemHeadFootEmptyAdapterBinding>>(R.layout.item_head_foot_empty_adapter) {
    override fun convert(
        holder: BaseDataBindingHolder<ItemHeadFootEmptyAdapterBinding>,
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