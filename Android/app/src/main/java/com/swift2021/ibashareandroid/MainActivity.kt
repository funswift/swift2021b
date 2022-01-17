package com.swift2021.ibashareandroid

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setupWithNavController((supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController)

//        naviMovement()
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit()
//        supportFragmentManager.beginTransaction().hide(currentFragment).commit()
//        supportFragmentManager.beginTransaction().show(fragment).commit()
        currentFragment = fragment
    }

    private val fragmentList = mutableListOf(TopPageFragment(), SearchPageFragment(), TalkPageFragment(), MyPageFragment())
    private var currentFragment = fragmentList[0]

    private fun naviMovement(){
        bottom_navigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.topPageFragment -> {
                    replaceFragment(fragmentList[0])
                    return@setOnItemSelectedListener true
                }
                R.id.searchPageFragment -> {
                    replaceFragment(fragmentList[1])
                    return@setOnItemSelectedListener true
                }
                R.id.talkPageFragment -> {
                    replaceFragment(fragmentList[2])
                    return@setOnItemSelectedListener true
                }
                R.id.myPageFragment -> {
                    replaceFragment(fragmentList[3])
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

}