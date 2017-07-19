package com.droidit.kotlinandroidplayground

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.droidit.kotlinandroidplayground.kotlinmon.KotlinMonMapsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hello_textview.text = "Hi"
        toast("Hi")
        start_find_age_btn.setOnClickListener({ FindAgeActivity.start(this) })
        start_tictac_btn.setOnClickListener({ TicTacToeActivity.start(this) })
        start_kotlinmon_btn.setOnClickListener({ KotlinMonMapsActivity.start(this) })
    }

    fun Context.toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
