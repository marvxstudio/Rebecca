package com.example.demo.fragment

import android.view.View
import com.example.demo.R
import com.example.demo.activity.Clicker
import com.example.demo.bean.RebeccaUser
import com.example.demo.databinding.RebeccaFragmentBinding
import com.example.demo.vm.RebeccaVM
import com.rebecca.lib.zbase.fragment.BaseVMFragment

class RebeccaFragment : BaseVMFragment<RebeccaFragmentBinding, RebeccaVM>(), Clicker {
    //=========================  =================================
    var colorCount = 0

    override fun onClick(v: View?) {
        when (v) {
            ui.ll -> {
                var color = 0
                colorCount++
                colorCount %= 2
                if (colorCount > 0) {
                    color = R.color.skyblue
                }
                else {
                    color = R.color.red_pressed
                }
                vm.color.postValue(color)
            }
        }
    }

    override var mLayoutId: Int = R.layout.rebecca_fragment

    override fun onCreateVM(vm: RebeccaVM): RebeccaVM {
        val user = RebeccaUser() //kotlin 可自动检测类型 	等效于 val user: RebeccaUser = RebeccaUser()   Java: RebeccaUser user= new RebeccaUser()
        user.userName.postValue("RebeccaApplication")
        user.userPassword.postValue("0000")
        user.userInfo.postValue("my name is RebeccaApplication")

        vm.bean.postValue(user)
        vm.color.postValue(R.color.skyblue)
        return super.onCreateVM(vm)
    }

    //=========================  =================================

    override fun onInitView() {
        super.onInitView()
        ui.vm = vm//createVM(RebeccaVM::class.java)  正常流程执行createVM方法获取Viewmodel
        ui.clicker = this
    }
    //========================= main ==================================
}