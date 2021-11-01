package com.swift2021.ibashareandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SeeMoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_more)
    }

    fun onButtonTapped(view: View?) {
        val intent = Intent(this, RecommendActivity::class.java)
        startActivity(intent)
    }
}