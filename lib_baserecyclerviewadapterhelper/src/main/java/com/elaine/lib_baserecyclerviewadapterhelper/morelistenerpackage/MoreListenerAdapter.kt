package com.elaine.lib_baserecyclerviewadapterhelper.morelistenerpackage

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.UpFetchModule
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ItemMoreListenerBinding

/**
 * 下拉和上拉加载
 */
class MoreListenerAdapter :
    BaseQuickAdapter<BaseBean?, BaseDataBindingHolder<ItemMoreListenerBinding>>(R.layout.item_more_listener),
    UpFetchModule {
    override fun convert(
        holder: BaseDataBindingHolder<ItemMoreListenerBinding>,
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