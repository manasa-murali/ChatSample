package com.example.chatappdemo.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.chatappdemo.R
import com.example.chatappdemo.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

/**
 * Created by Manasa on 29,June,2021
 */

@AndroidEntryPoint
class ChatFragment : Fragment(R.layout.chat_fragment) {

    private val viewModel: ChatViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            viewModel.getMessageFlow().collect {
                when (it) {
                    is ChatViewModel.ChatUIState.Failure -> {
                        Log.e("Failure", it.errorMessage)
                    }
                    ChatViewModel.ChatUIState.Initial -> {
                        Log.e("init", "init")
                    }
                    ChatViewModel.ChatUIState.Loading -> {
                        Log.e("Loading", "Loading")
                    }
                    is ChatViewModel.ChatUIState.Success -> {
                        Log.e("Success", it.messageUIData.toString())
                    }
                }
            }
        }

        viewModel.fetchChat()
    }
}