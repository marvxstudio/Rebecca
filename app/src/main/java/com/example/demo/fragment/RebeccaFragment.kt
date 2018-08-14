package com.example.demo.fragment

import com.example.demo.R
import com.example.demo.bean.RebeccaUser
import com.example.demo.databinding.RebeccaFragmentBinding
import com.example.demo.vm.RebeccaVM
import com.rebecca.lib.zbase.fragment.BaseVMFragment

class RebeccaFragment : BaseVMFragment<RebeccaFragmentBinding, RebeccaVM>() {
    //=========================  =================================

    override var mLayoutId: Int = R.layout.rebecca_fragment

    override fun onCreateVM(vm: RebeccaVM): RebeccaVM {
        val user = RebeccaUser() //kotlin 可自动检测类型 	等效于 val user: RebeccaUser = RebeccaUser()   Java: RebeccaUser user= new RebeccaUser()
        user.userName.postValue("Rebecca")
        user.userPassword.postValue("0000")
        user.userInfo.postValue("my name is Rebecca")

        vm.bean = user
        return super.onCreateVM(vm)
    }

    //=========================  =================================

    override fun onInitView() {
        super.onInitView()
        ui.vm = vm//createVM(RebeccaVM::class.java)  正常流程执行createVM方法获取Viewmodel
    }
    //========================= main ==================================
}