package com.droidit.kotlinandroidplayground

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_find_age.*
import kotlinx.android.synthetic.main.activity_tic_tac_toe.*
import java.util.*

class FindAgeActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, FindAgeActivity::class.java))
        }
    }


    //Really basic, will probably crash on some inputs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_age)
        player_indicator_tv
        find_age_calculate_btn.setOnClickListener({ find_age_output_tv.text = getAge(find_age_et.text.toString()).toString() })
    }

    fun getAge(inputAge: String?): Int {
        inputAge?.let {
            val inputAgeInt = inputAge.toInt()
            val currentDate = Calendar.getInstance().get(Calendar.YEAR)
            return currentDate - inputAgeInt
        }
        return 0
    }
}
