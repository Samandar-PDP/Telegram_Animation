package com.example.telegramanimation.model

data class User(
    val roundImage: Int,
    val nickName: String,
    val message: String,
    val countMsg: Int,
    val isOnline: Boolean
)