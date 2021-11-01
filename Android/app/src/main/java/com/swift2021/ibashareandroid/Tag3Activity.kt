package com.swift2021.ibashareandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Tag3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag3)
    }

    fun toBackButton(view: View?) {
        val intent = Intent(this, SeeMoreTag3Activity::class.java)
        startActivity(intent)
    }
}