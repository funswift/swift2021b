package com.swift2021.ibashareandroid


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var linearLayout: LinearLayout? = null
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
        initButton()
    }

    private fun initView() {
        val imageView: ImageView = findViewById(R.id.imageViewMain)
        val textView: TextView = findViewById(R.id.textViewMain)

        imageView.setImageResource(imageNames[aryIndex])
        textView.text = textNames[aryIndex]
    }

    private fun initButton() {
        val displayButton: Button = findViewById(R.id.button)
        displayButton.setOnClickListener {
            if (aryIndex < textNames.size) {
                aryIndex = (aryIndex + 1) % textNames.size
                imageChange()
            }
        }
    }

    private fun imageChange() {
        val imageView: ImageView = findViewById(R.id.imageViewMain)
        val textView: TextView = findViewById(R.id.textViewMain)
        val countView: TextView = findViewById(R.id.count)

        imageView.setImageResource(imageNames[aryIndex])
        textView.text = textNames[aryIndex]
        countView.text = ("" + (aryIndex + 1))
    }

}