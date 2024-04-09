package com.patch4code.loglinemovieapp.features.movie.presentation.components.watch_providers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.patch4code.loglinemovieapp.features.movie.domain.model.CountryProviders


@Composable
fun MovieWatchProviders(
    movieProviders: CountryProviders?,
    watchCountry: String?,
    movieId: Int?
){
    if (movieProviders == null) return

    val uriHandler = LocalUriHandler.current

    Row (modifier = Modifier
        .clickable { uriHandler.openUri("https://www.themoviedb.org/movie/$movieId/watch?locale=$watchCountry") }
    ){
        ProviderSection(movieProviders.flatrate, "Stream")
        Spacer(modifier = Modifier.padding(4.dp))
        ProviderSection(movieProviders.rent, "Rent/Buy")
    }

    Row(modifier = Modifier.padding(start = 10.dp, top = 10.dp)){
        Text(text = "Source: ")
        Text(text = "JustWatch", fontStyle = FontStyle.Italic)
    }
    HorizontalDivider(modifier = Modifier.padding(top = 16.dp))
}