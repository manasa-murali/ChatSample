package com.example.chatappdemo.di

import com.example.chatappdemo.model.MessageEntity
import com.example.chatappdemo.model.MessageUIData
import com.example.chatappdemo.repository.NetworkRepository
import com.example.chatappdemo.utils.INetworkMapper
import com.example.chatappdemo.utils.NetworkMapperImpl
import com.example.chatappdemo.viewmodel.ChatViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Manasa on 29,June,2021
 */

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun providesViewModel(networkRepository: NetworkRepository,networkMapperImpl: INetworkMapper<MessageUIData,MessageEntity>): ChatViewModel {
        return ChatViewModel(networkRepository,dataMapper = networkMapperImpl)
    }
}