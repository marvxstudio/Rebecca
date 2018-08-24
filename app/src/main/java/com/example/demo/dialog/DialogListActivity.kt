package com.example.demo.dialog

import android.view.View
import com.example.demo.R
import com.example.demo.activity.Clicker
import com.example.demo.databinding.DialogListActivityBinding
import com.example.demo.dialog.fragment.MaterialDialogFragment
import com.rebecca.lib.zbase.DialogManager
import com.rebecca.lib.zbase.activity.BaseDialogManagerActivity

class DialogListActivity(override var mLayoutId: Int = R.layout.dialog_list_activity) : BaseDialogManagerActivity<DialogListActivityBinding,
        DialogListVM>(), Clicker {
    //====================================================
    override fun onClick(v: View?) {
        dialogManager.add(MaterialDialogFragment())
    }

    //====================================================
    override fun onInitView() {
        super.onInitView()
        ui.clicker = this
        dialogManager = DialogManager(supportFragmentManager)
        var each = arrayListOf(0, 1)
        for (k in each) {

            //LogTools.show(k)
            dialogManager.add(MaterialDialogFragment())
            //dialogManager.add(MaterialDialogFragment())
            //dialogManager.list.add(MaterialDialogFragment())
        }
    }
    //========================= main ==================================
}