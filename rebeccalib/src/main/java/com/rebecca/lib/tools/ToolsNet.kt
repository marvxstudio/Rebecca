package com.rebecca.lib.tools

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class ToolsNet {
    companion object {

        fun isNetworkOn(context: Context): Boolean {
            var flag = false
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val info = connectivityManager.activeNetworkInfo
            if (info.isConnected) {
                if (info.state == NetworkInfo.State.CONNECTED) {
                    flag = true
                }
            }
            return flag
        }
    }
}
