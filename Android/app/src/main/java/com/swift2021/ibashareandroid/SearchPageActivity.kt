package com.swift2021.ibashareandroid


import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class SearchPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_page)

        //ナビゲーション
        navigation_icon_top_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        navigation_icon_talk_button.setOnClickListener {
            val intent = Intent(this, TalkPageActivity::class.java)
            startActivity(intent)
        }
        navigation_icon_my_page_button.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }

        navigation_icon_search.setColorFilter(ContextCompat.getColor(this, R.color.orange), PorterDuff.Mode.SRC_IN)
        navigation_icon_top.setColorFilter(ContextCompat.getColor(this, R.color.gray_74), PorterDuff.Mode.SRC_IN)
        navigation_icon_search_name.setTextColor(getColor(R.color.orange))

    }
}