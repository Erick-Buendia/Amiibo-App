package com.erick.buendia.disneyapp.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.erick.buendia.disneyapp.core.navigation.NavScreen
import com.erick.buendia.disneyapp.core.navigation.currentRoute


@Composable
fun SooTheBottomNavigation(modifier: Modifier = Modifier, navController: NavHostController) {
    val items = listOf(
        Items_bottom_navigation.Home,
        Items_bottom_navigation.Favorite,
    )
    NavigationBar(
        contentColor = MaterialTheme.colorScheme.background,
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        items.forEach { items ->
            val selected = currentRoute(navController) == items.route
            NavigationBarItem(
                icon = { Icon(imageVector = items.icon, contentDescription = null) },
                label = {
                    Text(text = items.title)
                },
                selected = selected,
                onClick = {
                    navController.navigate(items.route)
                }
            )
        }
    }
}

sealed class Items_bottom_navigation(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    object Home :
        Items_bottom_navigation("Home", Icons.Default.Home, NavScreen.HomeScreen.name)

    object Favorite :
        Items_bottom_navigation("Favorite", Icons.Default.Favorite, NavScreen.FavoriteScreen.name)
}