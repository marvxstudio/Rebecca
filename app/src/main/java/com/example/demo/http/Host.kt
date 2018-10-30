package com.example.demo.http

import com.rebecca.lib.http.host.BaseHost

class Host : BaseHost(IP.release) {

    private object IP {
        const val release = "192.168.0.1"
        const val debug = "192.168.0.2"
        const val t1 = "192.168.0.3"
    }
}