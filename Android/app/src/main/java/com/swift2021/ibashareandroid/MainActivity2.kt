package com.swift2021.ibashareandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val toBackPage: Button = findViewById(R.id.toBackPage)
        toBackPage.setOnClickListener {
            // 起動する対象をクラスオブジェクトで指定する
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}