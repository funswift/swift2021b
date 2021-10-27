package com.swift2021.ibashareandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Town11Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_town11)
    }
    // 戻るボタン
    fun onBackButtonTapped(view: View?) {
        finish()
    }
}