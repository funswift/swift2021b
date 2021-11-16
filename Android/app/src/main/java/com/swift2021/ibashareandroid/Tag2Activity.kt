package com.swift2021.ibashareandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Tag2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag2)
    }

    fun toBackButton(view: View?) {
        val intent = Intent(this, SeeMoreTag2Activity::class.java)
        startActivity(intent)
    }
}