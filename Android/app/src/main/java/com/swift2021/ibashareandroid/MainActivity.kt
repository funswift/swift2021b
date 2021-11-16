package com.swift2021.ibashareandroid


import android.os.Bundle
import android.content.Intent
import android.media.Image
import  android.widget.Button
import  android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var imageNames = arrayOf(
        R.drawable.fun_entaku,
        R.drawable.fun_entaku,
        R.drawable.fun_entaku,
        R.drawable.fun_entaku
    )
    private var textNames = arrayOf("亀田町", "美原町", "富岡町", "赤川町")
    private var aryIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val image1: ImageButton = findViewById(R.id.image1)
//        val image2: ImageButton = findViewById(R.id.image2)
//        val image3: ImageButton = findViewById(R.id.image3)
//        val image4: ImageButton = findViewById(R.id.image4)

        val placeName1: TextView = findViewById(R.id.place1)
        val placeName2: TextView = findViewById(R.id.place2)
        val placeName3: TextView = findViewById(R.id.place3)
        val placeName4: TextView = findViewById(R.id.place4)

        val image1: ImageView = findViewById(R.id.image1)
        val image2: ImageView = findViewById(R.id.image2)
        val image3: ImageView = findViewById(R.id.image3)
        val image4: ImageView = findViewById(R.id.image4)


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

        initView()
        timeEvent()

    }

    private fun initView() {
        val imageView: ImageView = findViewById(R.id.imageViewMain)
        val textView: TextView = findViewById(R.id.textViewMain)

        imageView.setImageResource(imageNames[aryIndex])
        textView.text = textNames[aryIndex]
    }

    private fun timeEvent() {
        var handler = Handler((Looper.getMainLooper()))

        val rnb = object : Runnable {
            override fun run() {
                handler.postDelayed(this, 5000)
                imageChange()
            }
        }
        handler.post(rnb)

    }

    private fun imageChange() {
        val imageView: ImageView = findViewById(R.id.imageViewMain)
        val textView: TextView = findViewById(R.id.textViewMain)

        imageView.setImageResource(imageNames[aryIndex])
        textView.text = textNames[aryIndex]

        aryIndex = (aryIndex + 1) % textNames.size
    }

}