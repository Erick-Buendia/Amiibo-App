package com.erick.buendia.disneyapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.erick.buendia.disneyapp.ui.screen.home.ListAmiiboScreen
import com.erick.buendia.disneyapp.ui.screen.favorite.FavoriteAmiiboScreen
import com.erick.buendia.disneyapp.ui.screen.home.HomeAmiiboViewModel

@Composable
fun NavigationWrapper(navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavScreen.HomeScreen.name) {
        composable(NavScreen.HomeScreen.name) {
            ListAmiiboScreen(modifier = Modifier, viewModel = HomeAmiiboViewModel())
        }
        composable(NavScreen.FavoriteScreen.name) {
            FavoriteAmiiboScreen(modifier = Modifier)
        }
    }
}