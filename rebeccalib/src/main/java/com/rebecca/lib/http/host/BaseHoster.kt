import com.rebecca.lib.http.host.BaseHost

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