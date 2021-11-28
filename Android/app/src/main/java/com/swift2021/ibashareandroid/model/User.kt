package com.swift2021.ibashareandroid.model

class User(val name:String, val townToLive:String) {

    var Shogi:Int? = null
    var Igo:Int? = null
    var Amimono:Int? = null

    fun tapShogi(){
        Igo = +1
    }

    fun tapIgo(){
        Shogi = +1
    }

    fun tapAmimono(){
        Amimono = +1
    }

}
