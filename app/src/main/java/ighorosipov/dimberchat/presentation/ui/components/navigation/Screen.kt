package ighorosipov.dimberchat.presentation.ui.components.navigation

sealed class Screen(val route: String) {
    data object SplashScreen : Screen("splash_screen")
    data object UsernameScreen : Screen("username_screen")
    data object GroupListScreen : Screen("group_list_screen")
    data object ChatScreen : Screen("chat_screen")
    data object SearchScreen : Screen("search_screen")
}
