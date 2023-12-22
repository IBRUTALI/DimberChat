package ighorosipov.dimberchat.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ighorosipov.dimberchat.R
import ighorosipov.dimberchat.presentation.ui.components.navigation.Screen
import ighorosipov.dimberchat.presentation.ui.components.navigation.USERNAME

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    currentDestinationRoute: String?,
    currentDestinationLabel: String?
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        ChangingLeftIconsForTopBar(
            navController = navController,
            route = currentDestinationRoute
        )
        Spacer(modifier = Modifier.width(8.dp))
        ChangingTitleForTopBar(
            route = currentDestinationRoute,
            label = currentDestinationLabel
        )
        Spacer(modifier = Modifier.width(8.dp))
        ChangingRightIconsForTopBar(route = currentDestinationRoute)
    }
}

@Composable
fun ChangingLeftIconsForTopBar(
    navController: NavController,
    route: String?,
    modifier: Modifier = Modifier
) {
    when (route) {
        Screen.SplashScreen.route -> {}
        Screen.UsernameScreen.route -> {}
        Screen.GroupListScreen.route -> {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = stringResource(R.string.menu),
                tint = Color.White,
                modifier = modifier.size(24.dp)
            )
        }

        "${Screen.ChatScreen.route}/{$USERNAME}", Screen.SearchScreen.route -> {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
                tint = Color.White,
                modifier = modifier
                    .size(24.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangingTitleForTopBar(
    route: String?,
    label: String?,
    modifier: Modifier = Modifier
) {
    when (route) {
        Screen.SplashScreen.route -> {}
        Screen.UsernameScreen.route -> {}
        Screen.GroupListScreen.route -> {
            Text(
                text = label ?: "",
                style = TextStyle(
                    fontSize = 16.sp
                )
                )
        }

        "${Screen.ChatScreen.route}/{$USERNAME}" -> {

        }

        Screen.SearchScreen.route -> {
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.search))
                }
            )
        }

    }
}

@Composable
fun ChangingRightIconsForTopBar(
    route: String?,
    modifier: Modifier = Modifier
) {
    when (route) {
        Screen.SplashScreen.route -> {}
        Screen.UsernameScreen.route -> {}
        Screen.GroupListScreen.route -> {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.search),
                tint = Color.White,
                modifier = modifier.size(24.dp)
            )
        }

        "${Screen.ChatScreen.route}/{$USERNAME}", Screen.SearchScreen.route -> {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = stringResource(R.string.morevert),
                tint = Color.White,
                modifier = modifier.size(24.dp)
            )
        }
    }
}