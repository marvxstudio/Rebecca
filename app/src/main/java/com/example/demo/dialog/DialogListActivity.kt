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
        dialogManager.addDialog(MaterialDialogFragment())
    }

    //====================================================
    override fun onInitView() {
        super.onInitView()
        ui.clicker = this
        dialogManager = DialogManager(supportFragmentManager)
        dialogManager.build()
        for (k in 0..1) {
            //dialogManager.addDialog(MaterialDialogFragment())
            //dialogManager.list.add(MaterialDialogFragment())
        }
    }
    //========================= main ==================================
}