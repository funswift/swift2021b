package com.swift2021.ibashareandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SeeMoreTag1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_more_tag1)
    }

    fun onButtonTapped(view: View?) {
        val intent = Intent(this, Tag1Activity::class.java)
        startActivity(intent)
    }
}