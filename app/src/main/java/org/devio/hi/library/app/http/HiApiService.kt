package org.devio.hi.library.app.http

import org.devio.hi.library.restful.HiCall

interface HiApiService {
    fun listCities(): HiCall<String>
}