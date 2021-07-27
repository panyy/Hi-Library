package org.devio.hi.library.app.http

import org.devio.hi.library.log.HiLog
import org.devio.hi.library.restful.HiInterceptor

class BizInterceptor : HiInterceptor {

    override fun intercept(chain: HiInterceptor.Chain): Boolean {
        if (chain.isRequestPeriod) {
            val request = chain.request()
            request.addHeader("auth-token", "MTU5Mjg1MDg3NDcwNw==")
        } else if (chain.response() != null) {
            HiLog.dt("BizInterceptor", chain.request().endPointUrl())
            HiLog.dt("BizInterceptor", chain.response()?.rawData)
        }
        return false
    }

}