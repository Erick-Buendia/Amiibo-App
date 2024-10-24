package com.erick.buendia.disneyapp.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.erick.buendia.disneyapp.core.navigation.NavigationWrapper
import com.erick.buendia.disneyapp.ui.component.SooTheBottomNavigation
import com.erick.buendia.disneyapp.ui.theme.DisneyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DisneyAppTheme {
                HomeScreen()
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Composable
    fun HomeScreen(modifier: Modifier = Modifier) {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { SooTheBottomNavigation(modifier, navController) },
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavigationWrapper(navController)
            }
        }
    }
}

