package ighorosipov.dimberchat.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ighorosipov.dimberchat.data.remote.ChatSocketService
import ighorosipov.dimberchat.data.remote.ChatSocketServiceImpl
import ighorosipov.dimberchat.data.remote.MessageService
import ighorosipov.dimberchat.data.remote.MessageServiceImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.websocket.WebSockets
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(Logging)
            install(WebSockets)
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
    }

    @Provides
    @Singleton
    fun provideMessageService(client: HttpClient): MessageService {
        return MessageServiceImpl(client)
    }

    @Provides
    @Singleton
    fun chatSocketService(client: HttpClient): ChatSocketService {
        return ChatSocketServiceImpl(client)
    }

}