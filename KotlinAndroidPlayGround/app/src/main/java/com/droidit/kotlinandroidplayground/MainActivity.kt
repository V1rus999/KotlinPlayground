package com.droidit.kotlinandroidplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hello_textview.text = "Hi"
        start_find_age_btn.setOnClickListener({ FindAgeActivity.start(this) })
    }
}
