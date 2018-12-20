package com.example.demo.activity

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.demo.R
import com.example.demo.bean.RebeccaUser
import com.example.demo.databinding.RebeccaActivityBinding
import com.example.demo.dialog.fragment.MaterialDialogFragment
import com.example.demo.fragment.RebeccaFragment
import com.example.demo.router.RouterUrl
import com.example.demo.vm.RebeccaVM
import com.rebecca.lib.zbase.activity.BaseVMActivity
import kotlinx.android.synthetic.main.rebecca_include.view.*

@Route(path = RouterUrl.App.COMMON)
class RebeccaActivity(override var mLayoutId: Int = R.layout.rebecca_activity) : BaseVMActivity<RebeccaActivityBinding,
        RebeccaVM>() {

    //=========================  =================================

    //=========================  =================================
    fun loadFragment() {
        var fm = supportFragmentManager
        var ft = fm.beginTransaction()
        var fragment = RebeccaFragment()
        //fragment.vm = vm
        ft.add(ui.flFragment.id, fragment)
        ft.commit()
    }

    //=========================  =================================
    var rebeccaClicker: Clicker = object : Clicker {
        override fun onClick(v: View?) {

            when (v) {
                ui.rlInclude.bt_login -> {
                    var isLogin: Boolean = vm.isLogin.value!!
                    vm.isLogin.postValue(!isLogin)
                }
                ui.rlInclude.bt_register -> {
                    vm.showBean()
                    MaterialDialogFragment().show(supportFragmentManager, "material")
                }
            }
        }
    }

    override fun onCreateVM(vm: RebeccaVM): RebeccaVM {
        vm.isLogin.postValue(true)
        val user = RebeccaUser()
        user.userName.postValue("RebeccaApplication")
        user.userPassword.postValue("123456")
        user.userInfo.postValue("my name is RebeccaApplication")
        vm.bean.postValue(user)
        return super.onCreateVM(vm)
    }

    override fun onInitView() {
        super.onInitView()
        ui.vm = createVM(RebeccaVM::class.java)
        ui.clicker = rebeccaClicker
        loadFragment()
    }
    //=========================main ==================================

}