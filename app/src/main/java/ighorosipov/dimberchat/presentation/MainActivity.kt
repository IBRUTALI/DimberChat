package ighorosipov.dimberchat.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ighorosipov.dimberchat.presentation.ui.components.TopBar
import ighorosipov.dimberchat.presentation.ui.components.navigation.Navigation
import ighorosipov.dimberchat.presentation.ui.components.navigation.Screen
import ighorosipov.dimberchat.presentation.ui.components.navigation.USERNAME
import ighorosipov.dimberchat.presentation.ui.theme.DimberChatTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DimberChatTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                Scaffold(
                    topBar = {
                        when (navBackStackEntry?.destination?.route) {
                            "${Screen.ChatScreen.route}/{$USERNAME}", Screen.GroupListScreen.route, Screen.SearchScreen.route -> {
                                TopBar(
                                    navController = navController,
                                    currentDestinationRoute = navBackStackEntry?.destination?.route,
                                    currentDestinationLabel = navBackStackEntry?.destination?.label.toString()
                                )
                            }
                        }
                    }
                ) { paddingValues ->
                    Navigation(
                        navController = navController,
                        paddingValues = paddingValues
                    )
                }
            }
        }
    }

}
