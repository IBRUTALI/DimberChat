package ighorosipov.dimberchat.presentation.ui.screens.chat

import ighorosipov.dimberchat.domain.model.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
