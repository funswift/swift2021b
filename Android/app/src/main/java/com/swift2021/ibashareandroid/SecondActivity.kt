package com.swift2021.ibashareandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_townlist.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Intent を取得する
        val intent = intent
        // キーを元にデータを取得する
        val text = intent.getIntExtra("town", 1)
    }

    // 戻るボタン
    fun onBackButtonTapped(view: View?) {
        finish()
    }

    fun onTown1Button(view: View?) {
        val intent = Intent(this, Town1Activity::class.java)
        startActivity(intent)
    }
    fun onTown2Button(view: View?) {
        val intent = Intent(this, Town2Activity::class.java)
        startActivity(intent)
    }
    fun onTown3Button(view: View?) {
        val intent = Intent(this, Town3Activity::class.java)
        startActivity(intent)
    }
    fun onTown4Button(view: View?) {
        val intent = Intent(this, Town4Activity::class.java)
        startActivity(intent)
    }
    fun onTown5Button(view: View?) {
        val intent = Intent(this, Town5Activity::class.java)
        startActivity(intent)
    }
    fun onTown6Button(view: View?) {
        val intent = Intent(this, Town6Activity::class.java)
        startActivity(intent)
    }
    fun onTown7Button(view: View?) {
        val intent = Intent(this, Town7Activity::class.java)
        startActivity(intent)
    }
    fun onTown8Button(view: View?) {
        val intent = Intent(this, Town8Activity::class.java)
        startActivity(intent)
    }
    fun onTown9Button(view: View?) {
        val intent = Intent(this, Town9Activity::class.java)
        startActivity(intent)
    }
    fun onTown10Button(view: View?) {
        val intent = Intent(this, Town10Activity::class.java)
        startActivity(intent)
    }
    fun onTown11Button(view: View?) {
        val intent = Intent(this, Town11Activity::class.java)
        startActivity(intent)
    }
    fun onTown12Button(view: View?) {
        val intent = Intent(this, Town12Activity::class.java)
        startActivity(intent)
    }
    fun onTown13Button(view: View?) {
        val intent = Intent(this, Town13Activity::class.java)
        startActivity(intent)
    }
}