package com.swift2021.ibashareandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.widget.Button


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val seeMoreKutikomi:Button = findViewById(R.id.seeMoreKutikomiButton)

        val placeName: TextView = findViewById(R.id.placeName)
        val placeImage: ImageView = findViewById(R.id.imageView)

        val placeImageInf = intent.getIntExtra("PlaceImage", 0)

        val getPlaceName = intent.getStringExtra("PlaceName")
        placeName.text = getPlaceName

        when (placeImageInf) {
            0 -> placeImage.setImageResource(R.mipmap.templete)
            1 -> placeImage.setImageResource(R.mipmap.place01)
            2 -> placeImage.setImageResource(R.mipmap.place02)
            3 -> placeImage.setImageResource(R.mipmap.place03)
            4 -> placeImage.setImageResource(R.mipmap.place04)
        }

        seeMoreKutikomi.setOnClickListener{
            val intent = Intent(this,AllReviewPage::class.java)
                    startActivity(intent)
        }

    }



    fun onButtonTapped(view: View?) {
        val intent = Intent(this, ParticipantActivity::class.java)
        startActivity(intent)
    }

    fun onBackButton(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onBackPageButton(view: View?){
        finish()
    }
}
