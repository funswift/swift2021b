package com.swift2021.ibashareandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ParticipantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_participant)
    }

    fun onButtonTapped(view: View?){
        finish()
    }

    fun onBackPageButton(view: View?) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}