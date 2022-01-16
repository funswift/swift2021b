package com.swift2021.ibashareandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        naviMovement()
    }

    private fun naviMovement(){
        bottom_navigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.navi_top -> {
                    return@setOnItemSelectedListener true
                }
                R.id.navi_search -> {
                    return@setOnItemSelectedListener true
                }
                R.id.navi_talk -> {
                    return@setOnItemSelectedListener true
                }
                R.id.navi_my_page -> {
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

}