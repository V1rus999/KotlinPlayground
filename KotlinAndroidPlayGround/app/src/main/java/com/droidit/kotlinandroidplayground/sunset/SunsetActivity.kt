package com.droidit.kotlinandroidplayground.sunset

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.droidit.kotlinandroidplayground.R
import kotlinx.android.synthetic.main.activity_sunset.*
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class SunsetActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SunsetActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sunset)
        find_town_sunset_btn.setOnClickListener({ onTownButtonClicked(town_et.text.toString()) })
    }

    fun onTownButtonClicked(townSelected: String) {
        val urlForSunset = "https://query.yahooapis.com/v1/public/yql?q=select%20astronomy.sunset%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22$townSelected%2C%20hi%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys"
        thread {
            try {
                val url = URL(urlForSunset)
                val connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout = 4000

                val result = connection.inputStream.bufferedReader().readText()
                val sunset = JSONObject(result).getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("astronomy").getString("sunset")
                postSunsetOutputToText("Sunset is at $sunset")

            } catch (ex: Exception) {
                postSunsetOutputToText(ex.toString())
            }
        }
    }

    fun postSunsetOutputToText(text: String) {
        runOnUiThread { find_sunset_output_tv.text = text }
    }
}
