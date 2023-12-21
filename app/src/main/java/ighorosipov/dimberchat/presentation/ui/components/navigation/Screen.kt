package ighorosipov.dimberchat.presentation.ui.components.navigation

sealed class Screen(val route: String) {
    data object SplashScreen : Screen("splash_screen")
    data object UsernameScreen : Screen("username_screen")
    data object ChatScreen : Screen("chat_screen")
}
