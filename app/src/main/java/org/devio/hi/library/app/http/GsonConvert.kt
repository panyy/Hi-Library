package org.devio.hi.library.app.http

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.devio.hi.library.restful.HiConvert
import org.devio.hi.library.restful.HiResponse
import org.json.JSONException
import org.json.JSONObject
import java.lang.reflect.Type

class GsonConvert : HiConvert {

    private var gson: Gson = Gson()

    override fun <T> convert(rawData: String, dataType: Type): HiResponse<T> {
        var response: HiResponse<T> = HiResponse()
        try {
            var jsonObject = JSONObject(rawData)
            response.code = jsonObject.optInt("code")
            response.msg = jsonObject.optString("msg")
            val data = jsonObject.optString("data")
            if (response.code == HiResponse.SUCCESS) {
                response.data = gson.fromJson(data, dataType)
            } else {
                response.errorData = gson.fromJson<MutableMap<String, String>>(
                    data,
                    object : TypeToken<MutableMap<String, String>>() {}.type
                )
            }
        } catch (e: JSONException) {
            e.printStackTrace()
            response.code = -1
            response.msg = e.message
        }
        response.rawData = rawData
        return response
    }

}