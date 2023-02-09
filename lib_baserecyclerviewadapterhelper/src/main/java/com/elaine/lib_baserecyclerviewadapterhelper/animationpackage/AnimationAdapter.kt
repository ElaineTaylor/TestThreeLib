package com.elaine.lib_baserecyclerviewadapterhelper.animationpackage

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.elaine.lib_baserecyclerviewadapterhelper.R
import com.elaine.lib_baserecyclerviewadapterhelper.bean.BaseBean
import com.elaine.lib_baserecyclerviewadapterhelper.databinding.ItemAnimationBinding

/**
 * 动画效果--适配器
 */
class AnimationAdapter :
    BaseQuickAdapter<BaseBean?, BaseDataBindingHolder<ItemAnimationBinding>>(R.layout.item_animation) {
    override fun convert(
        holder: BaseDataBindingHolder<ItemAnimationBinding>,
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