package ighorosipov.dimberchat.data.remote

import ighorosipov.dimberchat.domain.model.Message
import ighorosipov.dimberchat.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        username: String
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "ws://192.168.0.26:8080"
    }

    sealed class Endpoints(val url: String) {
        data object ChatSocket: Endpoints("${BASE_URL}/chat-socket")
    }

}