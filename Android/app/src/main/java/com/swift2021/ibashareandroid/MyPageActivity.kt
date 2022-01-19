package com.swift2021.ibashareandroid

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ListView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MyPageActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)


        val checkAmimono: SharedPreferences =
            getSharedPreferences("checkAmimono", MODE_PRIVATE)
        val checkShogi: SharedPreferences = getSharedPreferences("checkShogi", MODE_PRIVATE)
        val checkIgo: SharedPreferences = getSharedPreferences("checkIgo", MODE_PRIVATE)
        val checkCook: SharedPreferences = getSharedPreferences("checkCook", MODE_PRIVATE)

        val check_box_shogi:CheckBox = findViewById(R.id.check_box_shogi)
        val check_box_igo:CheckBox = findViewById(R.id.check_box_igo)
        val check_box_amimono:CheckBox = findViewById(R.id.check_box_amimono)
        val check_box_cook:CheckBox = findViewById(R.id.check_box_cook)

        val checkedShogi = checkShogi.getBoolean("DataShogi",false)
        val checkedIgo = checkShogi.getBoolean("DataIgo",false)
        val checkedAmimono = checkShogi.getBoolean("DataAmimono",false)
        val checkedCook = checkShogi.getBoolean("DataCook",false)

        check_box_shogi.isChecked = checkedShogi
        check_box_igo.isChecked = checkedIgo
        check_box_amimono.isChecked = checkedAmimono
        check_box_cook.isChecked = checkedCook

        val shogiEditor = checkShogi.edit()
        val igoEditor = checkShogi.edit()
        val amimonoEditor = checkShogi.edit()
        val cookEditor = checkShogi.edit()

        check_box_shogi.setOnClickListener{
            shogiEditor.putBoolean("DataShogi",true)
            shogiEditor.apply()
        }
        check_box_igo.setOnClickListener{
            igoEditor.putBoolean("DataIgo",true)
            igoEditor.apply()
        }
        check_box_amimono.setOnClickListener{
            amimonoEditor.putBoolean("DataAmimono",true)
            amimonoEditor.apply()
        }
        check_box_cook.setOnClickListener{
            cookEditor.putBoolean("DataCook",true)
            cookEditor.apply()
        }
        //ナビゲーション
        navigation_icon_search_button.setOnClickListener {
            val intent = Intent(this, SearchPageActivity::class.java)
            startActivity(intent)
        }
        navigation_icon_talk_button.setOnClickListener {
            val intent = Intent(this, TalkPageActivity::class.java)
            startActivity(intent)
        }
        navigation_icon_top_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        navigation_icon_my_page.setColorFilter(ContextCompat.getColor(this, R.color.orange), PorterDuff.Mode.SRC_IN)
        navigation_icon_top.setColorFilter(ContextCompat.getColor(this, R.color.gray_74), PorterDuff.Mode.SRC_IN)
        navigation_icon_my_page_name.setTextColor(getColor(R.color.orange))

        val myGenreList = mutableListOf("将棋","囲碁","編み物","料理")


        val listView = findViewById<ListView>(R.id.list_view)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myGenreList)

        listView.adapter = adapter


    }
}