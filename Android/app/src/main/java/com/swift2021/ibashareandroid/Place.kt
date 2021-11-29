package com.swift2021.ibashareandroid

import com.google.firebase.firestore.DocumentId

data class Place(
    @DocumentId
    val id: String = "",
    val title: String = "",
    val information: String = "",
    val address: String = ""
)
