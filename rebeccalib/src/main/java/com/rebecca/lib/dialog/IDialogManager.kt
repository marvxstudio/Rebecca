package com.rebecca.lib.dialog

import android.content.DialogInterface
import android.support.v4.app.DialogFragment

interface IDialogManager<DF : DialogFragment> {

    fun add(dialog: DF)

    fun output()

    fun onDismiss(dialog: DialogInterface?)

    fun onStart()

    fun onDestroy()
}