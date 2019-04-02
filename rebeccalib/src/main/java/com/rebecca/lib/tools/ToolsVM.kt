package com.rebecca.lib.tools

import java.lang.reflect.ParameterizedType

object ToolsVM {
  fun <VM> createClassVM(p: Any): Class<VM> {
    val genType = p.javaClass.genericSuperclass
    val actualTypeArgs = (genType as ParameterizedType).actualTypeArguments
    return actualTypeArgs[1] as Class<VM>
  }
}