package com.swift2021.ibashareandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SeeTownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_town)
    }

    // ボタンタップ時
    fun onButtonTapped(view: View?) {
        val intent = Intent(this, TownListActivity::class.java)
        startActivity(intent)
    }
}