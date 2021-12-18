package com.swift2021.ibashareandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testTopFragment = TopPageFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, testTopFragment)
        transaction.commit()
    }


}