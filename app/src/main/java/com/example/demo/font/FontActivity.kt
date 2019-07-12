package com.example.demo.font

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.demo.R
import com.example.demo.databinding.FontActivityBinding
import com.example.demo.router.RouterUrl
import com.example.demo.zbase.Clicker
import com.rebecca.lib.tools.Loger
import com.rebecca.lib.zbase.activity.BaseVMActivity

@Route(path = RouterUrl.App.Font)
class FontActivity(override var mLayoutId: Int = R.layout.font_activity) : BaseVMActivity<FontActivityBinding, FontVM>(), Clicker {
  //=========================  =================================

  override val classVM: Class<FontVM> = FontVM::class.java
  //=========================  =================================
  var i = 0

  override fun onClick(v: View?) {
    val c = (i++).toString()

    vm.bean1.text = c
    vm.bean2.text.set(c)
//    vm.bean3.get()?.text = c
    vm.bean3.let {
      it.get()?.let {
        it.text = c
        vm.bean3.set(it.copy())
      }
    }
    vm.bean4.set(FontVM.FTest().apply { text = c })
    vm.bean5.value = FontVM.FTest().apply { text = c }
    vm.bean6.value?.text = c

    vm.bean7.text.value = c
    Loger.show("""=
      |bean1= ${vm.bean1.text}
      |bean2= ${vm.bean2.text.get()}
      |bean3= ${vm.bean3.get()?.text}
      |bean4= ${vm.bean4.get()?.text}
      |
      |bean5= ${vm.bean5.value?.text}
      |bean6= ${vm.bean6.value?.text}
      |bean7= ${vm.bean7.text.value}
      |""".trimMargin())
  }
  //=========================  =================================

  //========================= init  =================================

  override fun onInitView() {
    super.onInitView()
    ui.vm = createVM(FontVM::class.java)
    ui.clicker = this
    var k: String? = null
    k?.let {
      Loger.show("不为空= $k")
    } ?: k.let {
      Loger.show(it.toString())
    }

  }
  //========================= main ==================================
}