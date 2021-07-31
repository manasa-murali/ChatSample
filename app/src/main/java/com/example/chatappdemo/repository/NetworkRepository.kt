package com.example.chatappdemo.repository

import com.example.chatappdemo.model.MessageEntity
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Manasa on 29,June,2021
 */

class NetworkRepository
@Inject
constructor(
    private val chatApi: ChatApi
) {
    suspend fun fetchMessages(): Response<MessageEntity> {
        return chatApi.fetchMessages()
    }
}