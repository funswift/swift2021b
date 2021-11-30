package com.swift2021.ibashareandroid

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.firestore.DocumentId

data class UserData(
    @DocumentId
    val id: String = "",
    val name:String = "",
    val genre1: String = "",
    val genre2: String = "",
    val genre3: String = "",
    val genre4: String = "",
    val genre5: String = "",

){


    var shogi:Int = 0
    var igo:Int = 0
    var amimono:Int = 0
    var cook:Int = 0

    fun tapShogi(){
        shogi += 1
        Log.d("GENRE", "将棋の選択数は"+shogi.toString())

    }
    fun tapIgo(){
        igo += 1
        Log.d("GENRE", "囲碁の選択数は"+igo.toString())

    }
    fun tapAmimono(){
        amimono += 1
        Log.d("GENRE", "編み物の選択数は"+amimono.toString())

    }
    fun tapCook(){
        cook += 1
        Log.d("GENRE", "料理の選択数は"+cook.toString())

    }



}
