package com.swift2021.ibashareandroid


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
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