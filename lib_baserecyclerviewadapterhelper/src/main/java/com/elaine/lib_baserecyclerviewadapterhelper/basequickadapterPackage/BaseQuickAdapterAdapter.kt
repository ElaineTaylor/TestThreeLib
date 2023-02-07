package com.elaine.lib_baserecyclerviewadapterhelper.basequickadapterPackage

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ItemBaseQuickAdapterBinding

/**
 * 基础使用--BaseQuickAdapter
 * 适配器
 */
class BaseQuickAdapterAdapter :
    BaseQuickAdapter<BaseBean?, BaseDataBindingHolder<ItemBaseQuickAdapterBinding>>(R.layout.item_base_quick_adapter) {
    override fun convert(
        holder: BaseDataBindingHolder<ItemBaseQuickAdapterBinding>,
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