package ighorosipov.dimberchat.presentation.ui.components.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ighorosipov.dimberchat.presentation.ui.screens.chat.ChatScreen
import ighorosipov.dimberchat.presentation.ui.screens.username.UsernameScreen

const val USERNAME = "username"

@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screen.UsernameScreen.route
    ) {
        composable(Screen.UsernameScreen.route) {
            UsernameScreen(
                paddingValues = paddingValues,
                onNavigate = navController::navigate
            )
        }
        composable(
            route = "${Screen.ChatScreen.route}/{$USERNAME}",
            arguments = listOf(
                navArgument(name = USERNAME) {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            val username = it.arguments?.getString(USERNAME)
            ChatScreen(
                paddingValues = paddingValues,
                username = username
            )
        }
    }

}