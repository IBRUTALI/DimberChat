package ighorosipov.dimberchat.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import ighorosipov.dimberchat.presentation.ui.components.TopBar
import ighorosipov.dimberchat.presentation.ui.components.navigation.Navigation
import ighorosipov.dimberchat.presentation.ui.screens.chat.ChatScreen
import ighorosipov.dimberchat.presentation.ui.screens.username.UsernameScreen
import ighorosipov.dimberchat.presentation.ui.theme.DimberChatTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopBar {

                    }
                }
            ) { paddingValues ->
                Navigation(paddingValues)
            }

        }
    }

}
