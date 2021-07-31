package com.example.chatappdemo.repository

import com.example.chatappdemo.model.MessageEntity
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Manasa on 29,June,2021
 */

interface ChatApi {

    @GET("/instance295838/messages?token=el1xmff1bn3vpe98")
    suspend fun fetchMessages(): Response<MessageEntity>

}