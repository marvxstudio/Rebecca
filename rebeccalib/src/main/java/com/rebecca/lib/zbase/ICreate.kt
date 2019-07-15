package com.rebecca.lib.zbase

import android.arch.lifecycle.LifecycleOwner

interface ICreate {

  //==============================================
  fun onInit()

  fun onInitView()

  fun onInitData()

  fun onDestroyVM(owner: LifecycleOwner)

  //fun onCreateVM(context: Context,classVM:Class<VM : viewmodel>)

  //fun onCreateBinding()
}