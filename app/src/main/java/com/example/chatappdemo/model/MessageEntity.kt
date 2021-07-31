package com.example.chatappdemo.model


import com.google.gson.annotations.SerializedName

data class MessageEntity(
    @SerializedName("lastMessageNumber")
    val lastMessageNumber: Int? = null,
    @SerializedName("messages")
    val messages: List<Message>? = null
) {
    data class Message(
        @SerializedName("ack")
        val ack: Any? = null,
        @SerializedName("author")
        val author: String? = null,
        @SerializedName("body")
        val body: String? = null,
        @SerializedName("chatId")
        val chatId: String? = null,
        @SerializedName("chatName")
        val chatName: String? = null,
        @SerializedName("fromMe")
        val fromMe: Boolean? = null,
        @SerializedName("id")
        val id: String? = null,
        @SerializedName("isForwarded")
        val isForwarded: Int? = null,
        @SerializedName("messageNumber")
        val messageNumber: Int? = null,
        @SerializedName("metadata")
        val metadata: Any? = null,
        @SerializedName("quotedMsgBody")
        val quotedMsgBody: Any? = null,
        @SerializedName("quotedMsgId")
        val quotedMsgId: Any? = null,
        @SerializedName("quotedMsgType")
        val quotedMsgType: Any? = null,
        @SerializedName("self")
        val self: Int? = null,
        @SerializedName("senderName")
        val senderName: String? = null,
        @SerializedName("time")
        val time: Int? = null,
        @SerializedName("type")
        val type: String? = null
    )
}