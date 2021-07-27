package org.devio.hi.library.app.http

import com.google.gson.JsonObject
import org.devio.hi.library.restful.HiCall
import org.devio.hi.library.restful.annotation.Filed
import org.devio.hi.library.restful.annotation.GET

interface HiApiService {

    @GET("cities")
    fun listCities(@Filed("name") name: String): HiCall<JsonObject>
}