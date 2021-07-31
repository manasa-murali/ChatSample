package com.example.chatappdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatappdemo.model.MessageEntity
import com.example.chatappdemo.model.MessageUIData
import com.example.chatappdemo.repository.NetworkRepository
import com.example.chatappdemo.utils.INetworkMapper
import com.example.chatappdemo.utils.NetworkMapperImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Manasa on 29,June,2021
 */

@HiltViewModel
class ChatViewModel
@Inject
constructor(
    private val networkRepository: NetworkRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val dataMapper: INetworkMapper<MessageUIData,MessageEntity>
) : ViewModel() {

    private val messageStateFlow : MutableStateFlow<ChatUIState> = MutableStateFlow(ChatUIState.Initial)

    fun getMessageFlow(): StateFlow<ChatUIState> {
        return messageStateFlow.asStateFlow()
    }

    fun fetchChat() {

        messageStateFlow.value = ChatUIState.Loading

        viewModelScope.launch(dispatcher) {
            val response = networkRepository.fetchMessages()
            if (response.isSuccessful) {
                val messageEntity = response.body()
                if (messageEntity != null) {
                    val messageUIData = dataMapper.mapFromEntity(messageEntity)
                    val success = ChatUIState.Success(messageUIData)
                    messageStateFlow.value = success
                } else {
                    messageStateFlow.value = ChatUIState.Failure(-1,"Body Null")
                }
            } else {
                //Failed
                messageStateFlow.value = ChatUIState.Failure(response.code(),response.message())
            }

        }

    }

    sealed class ChatUIState {
        object Initial: ChatUIState()
        object Loading : ChatUIState()
        data class Success(val messageUIData: MessageUIData) : ChatUIState()
        data class Failure(val errorCode: Int, val errorMessage: String) : ChatUIState()
    }
}