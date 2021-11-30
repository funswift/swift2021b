package com.swift2021.ibashareandroid

import com.google.firebase.firestore.DocumentId

data class UserData(
    @DocumentId
    val id: String = "",
    val genre1: String = "",
    val genre2: String = "",
    val genre3: String = "",
    val genre4: String = "",
    val genre5: String = ""
)
