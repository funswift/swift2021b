package com.swift2021.ibashareandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_townlist.*
import android.view.View
import android.widget.TextView




class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Intent を取得する
        val intent = intent
        // キーを元にデータを取得する
        val text = intent.getIntExtra("town", 1)
        val txt = findViewById<View>(R.id.textview) as TextView

        when (text) {
            1 -> town1.text
            2 -> town2.text
            3 -> town3.text
            4 -> town4.text
            5 -> town5.text
            6 -> town6.text
            7 -> town7.text
            8 -> town8.text
            9 -> town9.text
            10 -> town10.text
            11 -> town11.text
            12 -> town12.text
            13 -> town13.text
        }
        txt.text = text.toString()
    }
}