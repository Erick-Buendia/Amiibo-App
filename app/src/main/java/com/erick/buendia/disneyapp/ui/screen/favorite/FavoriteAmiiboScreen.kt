package com.erick.buendia.disneyapp.ui.screen.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.erick.buendia.disneyapp.R
import com.erick.buendia.disneyapp.domain.model.AmiiboModel


@Composable
fun FavoriteAmiiboScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteAmiiboViewModel = hiltViewModel()
) {
    viewModel.getAmiiboListFavorite()
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        AmiiboGrid(modifier = modifier.padding(top = 16.dp), viewModel)
    }

}

@Composable
fun AmiiboGrid(modifier: Modifier = Modifier, viewModel: FavoriteAmiiboViewModel) {

    val amiiboList by viewModel.amiiboListFavorite.observeAsState(arrayListOf())

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        amiiboList.map {
            item {
                AmiiboCard(
                    amiibo = it,
                    modifier = Modifier,
                    viewModel
                )
            }
        }
    }
}


@Composable
fun AmiiboCard(
    amiibo: AmiiboModel,
    modifier: Modifier = Modifier,
    viewModel: FavoriteAmiiboViewModel
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,

        ) {
        Column {
            AsyncImage(
                model = amiibo.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Text(
                text = amiibo.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Row(modifier = Modifier.padding(top = 8.dp, bottom = 2.dp, start = 8.dp)) {
                Icon(
                    painterResource(R.drawable.icon_video_game),
                    contentDescription = ""
                )
                Text(
                    text = amiibo.gameSeries,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            Row(modifier = Modifier.padding(top = 4.dp, start = 8.dp)) {
                Icon(
                    painterResource(R.drawable.icon_swords),
                    contentDescription = ""
                )
                Text(
                    text = amiibo.character,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            IconButton(modifier = Modifier.align(Alignment.End), onClick = {
                viewModel.removeFavoriteAmiibo(amiibo)
            }) {
                Icon(
                    painterResource(R.drawable.icon_favorite),
                    contentDescription = "",
                    tint = Color(0xFFCE1616)
                )
            }
        }
    }
}