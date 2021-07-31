package com.example.chatappdemo.di

import com.example.chatappdemo.model.MessageEntity
import com.example.chatappdemo.model.MessageUIData
import com.example.chatappdemo.repository.ChatApi
import com.example.chatappdemo.repository.NetworkRepository
import com.example.chatappdemo.utils.INetworkMapper
import com.example.chatappdemo.utils.NetworkMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Manasa on 29,June,2021
 */

@Module
@InstallIn(SingletonComponent::class)
class ChatModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.chat-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(chatApi: ChatApi): NetworkRepository {
        return NetworkRepository(chatApi)
    }

    @Provides
    @Singleton
    fun provideChatAPI(retrofit: Retrofit): ChatApi {
        return retrofit.create(ChatApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNetworkMapper(): INetworkMapper<MessageUIData,MessageEntity>{
        return NetworkMapperImpl()
    }
}