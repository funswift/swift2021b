package com.swift2021.ibashareandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Town5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_town5)
    }
    // 戻るボタン
    fun onBackButtonTapped(view: View?) {
        finish()
    }
}