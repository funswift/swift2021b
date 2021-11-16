package com.swift2021.ibashareandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class TownActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_town)
        val townName: TextView = findViewById(R.id.textView)
        val getTownName = intent.getStringExtra("town")
        townName.text = getTownName
    }

    // 戻るボタン
    fun onBackButtonTapped(view: View?) {
        finish()
    }
}