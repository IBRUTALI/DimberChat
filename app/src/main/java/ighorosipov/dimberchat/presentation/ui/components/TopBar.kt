package ighorosipov.dimberchat.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        ChangingIconForTopBar(
            imageVectorLeft = Icons.Default.Menu,
            imageVectorRight = Icons.Default.ArrowBack,
            route = navBackStackEntry?.destination?.route
        )
        Spacer(modifier = Modifier.width(8.dp))
        ChangingTitleForTopBar(
            route = navBackStackEntry?.destination?.route,
            label = navBackStackEntry?.destination?.label.toString()
        )
        Spacer(modifier = Modifier.width(8.dp))
        ChangingIconForTopBar(
            imageVectorLeft = Icons.Default.Search,
            imageVectorRight = Icons.Default.MoreVert,
            route = navBackStackEntry?.destination?.route
        )

    }
}

@Composable
fun ChangingIconForTopBar(
    imageVectorLeft: ImageVector,
    imageVectorRight: ImageVector,
    route: String?,
    modifier: Modifier = Modifier
) {
    when (route) {
        Screen.SplashScreen.route -> {}
        Screen.UsernameScreen.route -> {}
        Screen.GroupListScreen.route -> {
            Icon(
                imageVector = imageVectorLeft,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(24.dp)
            )
        }

        Screen.ChatScreen.route, Screen.SearchScreen.route -> {
            Icon(
                imageVector = imageVectorRight,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(24.dp)
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

        Screen.ChatScreen.route -> {

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