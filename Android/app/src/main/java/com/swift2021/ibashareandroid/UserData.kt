package com.swift2021.ibashareandroid

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
    }
    fun tapIgo(){
        igo += 1
    }
    fun tapAmimono(){
        amimono += 1
    }
    fun tapCook(){
        cook += 1
    }



}
