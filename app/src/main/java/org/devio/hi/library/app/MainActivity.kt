package org.devio.hi.library.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonObject
import org.devio.hi.library.app.demo.HiLogDemoActivity
import org.devio.hi.library.app.http.ApiFactory
import org.devio.hi.library.app.http.HiApiService
import org.devio.hi.library.restful.HiCallback
import org.devio.hi.library.restful.HiResponse

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tv_hilog -> {
                listCities()
                //startActivity(Intent(this, HiLogDemoActivity::class.java))
            }
        }
    }

    private fun listCities() {
        ApiFactory.create(HiApiService::class.java).listCities("imooc")
            .enqueue(object : HiCallback<JsonObject> {
                override fun onSuccess(response: HiResponse<JsonObject>) {
                }

                override fun onFailed(throwable: Throwable) {
                }
            })
    }

}
