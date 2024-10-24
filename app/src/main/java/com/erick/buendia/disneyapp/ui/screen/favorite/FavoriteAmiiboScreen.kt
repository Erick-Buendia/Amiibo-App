package com.erick.buendia.disneyapp.ui.screen.favorite

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavoriteAmiiboScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        AmiiboGrid(modifier = modifier.padding(top = 16.dp))
    }

}

@Composable
fun AmiiboGrid(modifier: Modifier = Modifier) {
    Text(text = "Esto es favoritos")
}