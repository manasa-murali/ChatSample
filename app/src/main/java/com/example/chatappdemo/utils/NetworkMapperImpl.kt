package com.example.chatappdemo.utils

import com.example.chatappdemo.model.MessageEntity
import com.example.chatappdemo.model.MessageUI
import com.example.chatappdemo.model.MessageUIData

class NetworkMapperImpl : INetworkMapper<MessageUIData,MessageEntity> {
    override fun mapFromEntity(entity: MessageEntity): MessageUIData {
        val messageList = arrayListOf<MessageUI>()
        entity.messages!!.forEach {
            val messageUI = MessageUI(
                author = it.author,
                body = it.body,
                chatId = it.chatId,
                fromMe = it.fromMe,
                senderName = it.senderName,
                time = it.time
            )
            messageList.add(messageUI)
        }
        return MessageUIData(messageList.toList())
    }

}