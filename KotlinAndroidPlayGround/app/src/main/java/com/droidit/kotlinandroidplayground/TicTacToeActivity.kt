package com.droidit.kotlinandroidplayground

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tic_tac_toe.*

class TicTacToeActivity : AppCompatActivity() {

    //Stopping this as its not really teaching me anything new with regards to kotlin, might look at it again oneday

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, TicTacToeActivity::class.java))
        }
    }

    var clickCount: Int = 1

    fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        btnReset.setOnClickListener({
            button1.text = ""
            button1.isEnabled = true
            button2.text = ""
            button2.isEnabled = true
            button3.text = ""
            button3.isEnabled = true
            button4.text = ""
            button4.isEnabled = true
            button5.text = ""
            button5.isEnabled = true
            button6.text = ""
            button6.isEnabled = true
            button7.text = ""
            button7.isEnabled = true
            button8.text = ""
            button8.isEnabled = true
            button9.text = ""
            button9.isEnabled = true
            clickCount = 1
            player_indicator_tv.text = "Player 1 turn"
        })
    }

    fun OnTicTacClick(view: View) {
        val selectedBtn = view as Button
        var selectedCell = 0
        updateCurrentPlayer()
        when (selectedBtn.id) {
            R.id.button1 -> selectedCell = 1
            R.id.button2 -> selectedCell = 2
            R.id.button3 -> selectedCell = 3
            R.id.button4 -> selectedCell = 4
            R.id.button5 -> selectedCell = 5
            R.id.button6 -> selectedCell = 6
            R.id.button7 -> selectedCell = 7
            R.id.button8 -> selectedCell = 8
            R.id.button9 -> selectedCell = 9
        }
        selectedBtn.isEnabled = false
        selectedBtn.text = if (clickCount % 2 == 0) "O" else "X"
        clickCount++
    }

    fun updateCurrentPlayer() {
        player_indicator_tv.text = "Player ${if (clickCount % 2 == 0) "1" else "2"} turn"
    }
}
