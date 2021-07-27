package org.devio.hi.library.app.http

import org.devio.hi.library.restful.HiRestful

object ApiFactory {
    val baseUrl = "https://api.devio.org/as/"
    val hiRestful = HiRestful(baseUrl, RetrofitCallFactory(baseUrl))

    init {
        hiRestful.addInterceptor(BizInterceptor())
    }

    fun <T> create(service: Class<T>): T {
        return hiRestful.create(service)
    }
}