package com.erick.buendia.disneyapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun currentRoute(navController: NavController): String? =
    navController.currentBackStackEntryAsState().value?.destination?.route