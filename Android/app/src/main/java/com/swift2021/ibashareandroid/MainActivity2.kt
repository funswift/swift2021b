package com.swift2021.ibashareandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val placeName:TextView = findViewById(R.id.placeName)

        val getPlaceName = intent.getStringExtra("PlaceName")
        placeName.text = getPlaceName

    }
}