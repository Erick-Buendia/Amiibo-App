package com.erick.buendia.disneyapp.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.erick.buendia.disneyapp.R
import com.erick.buendia.disneyapp.domain.model.AmiiboModel


@Composable
fun ListAmiiboScreen(modifier: Modifier = Modifier, viewModel: HomeAmiiboViewModel  = hiltViewModel()) {

    viewModel.getAmiiboList()

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        AmiiboGrid(modifier = modifier.padding(top = 16.dp),viewModel)
    }

}


@Composable
fun AmiiboGrid(modifier: Modifier = Modifier, viewModel: HomeAmiiboViewModel) {

    val amiiboList by viewModel.amiiboList.observeAsState(arrayListOf())

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(amiiboList) { amiibo ->
            AmiiboCard(
                amiibo,
                modifier = Modifier
            )

        }
    }
}


@Composable
fun AmiiboCard(
    amiibo:AmiiboModel,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,

        ) {
        Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = amiibo.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)

            )
            Column() {
                Text(
                    text = amiibo.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Row(modifier = Modifier.padding(start = 16.dp)) {
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
                Row(Modifier.padding(start = 16.dp)) {
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
            }

        }
    }
}