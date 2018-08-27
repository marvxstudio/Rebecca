package com.example.demo.dialog

import android.view.View
import com.example.demo.R
import com.example.demo.activity.Clicker
import com.example.demo.databinding.DialogListFragmentBinding
import com.example.demo.dialog.fragment.MaterialDialogFragment
import com.rebecca.lib.zbase.fragment.BaseVMFragment

class DialogListFragment : BaseVMFragment<DialogListFragmentBinding, DialogListVM>(), Clicker {

    //====================================================
    override var mLayoutId: Int = R.layout.dialog_list_fragment
    //====================================================
    override fun onClick(v: View?) {
        dialogManager?.add(MaterialDialogFragment())
    }

    //====================================================
    override fun onInitView() {
        super.onInitView()
        ui.clicker = this
        var each = arrayListOf(0, 1)
        for (k in each) {

            dialogManager?.add(MaterialDialogFragment())
        }
    }
    //========================= main ==================================
}