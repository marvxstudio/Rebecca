package com.rebecca.lib.http.host

abstract class BaseHoster(var type: HostType = HostType.RELEASE) {

    //======================================================
    enum class HostType {
        RELEASE,
        PREVIEW,
        DEBUG,
        CUSTOM,
    }

    //======================================================
    protected abstract fun createHost(): BaseHost
}