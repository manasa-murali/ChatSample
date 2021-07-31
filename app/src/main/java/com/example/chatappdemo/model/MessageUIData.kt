package com.example.chatappdemo.model

/**
 * Created by Manasa on 29,June,2021
 */
data class MessageUIData(
    val messages: List<MessageUI?>? = null
)

data class MessageUI(
    val author: String?,
    val body: String?,
    val chatId: String?,
    val fromMe: Boolean?,
    val senderName: String?,
    val time: Int?
)