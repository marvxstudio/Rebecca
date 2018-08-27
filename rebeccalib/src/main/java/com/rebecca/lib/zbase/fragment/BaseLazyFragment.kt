package com.rebecca.lib.zbase.fragment

abstract class BaseLazyFragment : BaseDMFragment() {
    //=========================  =================================

    //=========================  =================================
    var isLoaded: Boolean = false//false=未加载

    //=========================  =================================
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        onInit()
    }

    override fun onInit() {
        if (isStartInit()) {
            super.onInit()
            isLoaded = true
        }
    }

    open fun isStartInit(): Boolean {//懒加载条件
        return userVisibleHint && mRootView != null && isLoaded == false
    }
    //========================= main ==================================

}