package com.swift2021.ibashareandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.media.Image
import  android.widget.Button
import  android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image1: ImageButton = findViewById(R.id.image1)
        val image2: ImageButton = findViewById(R.id.image2)
        val image3: ImageButton = findViewById(R.id.image3)
        val image4: ImageButton = findViewById(R.id.image4)

        val placeName1: TextView = findViewById(R.id.place1)
        val placeName2: TextView = findViewById(R.id.place2)
        val placeName3: TextView = findViewById(R.id.place3)
        val placeName4: TextView = findViewById(R.id.place4)





        image1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", placeName1.text.toString())
            intent.putExtra("PlaceImage", 1)
            startActivity(intent)
        }

        image2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", placeName2.text.toString())
            intent.putExtra("PlaceImage", 2)

            startActivity(intent)
        }

        image3.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", placeName3.text.toString())
            intent.putExtra("PlaceImage", 3)
            startActivity(intent)
        }

        image4.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", placeName4.text.toString())
            intent.putExtra("PlaceImage", 4)
            startActivity(intent)
        }

    }
}