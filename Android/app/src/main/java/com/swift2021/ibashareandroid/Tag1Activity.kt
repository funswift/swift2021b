package com.swift2021.ibashareandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Tag1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag1)
    }

    fun toBackButton(view: View?) {
        val intent = Intent(this, SeeMoreTag1Activity::class.java)
        startActivity(intent)
    }
}