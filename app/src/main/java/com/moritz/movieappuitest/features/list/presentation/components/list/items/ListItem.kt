package com.moritz.movieappuitest.features.list.presentation.components.list.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.moritz.movieappuitest.R
import com.moritz.movieappuitest.features.navigation.domain.model.Screen
import com.moritz.movieappuitest.features.core.domain.model.Movie
import com.moritz.movieappuitest.features.core.presentation.utils.MovieHelper

@Composable
fun ListItem(navController: NavController, movie: Movie){

    val movieId = movie.id.toString()
    val movieTitle = movie.title
    val movieYear = MovieHelper.extractYear(movie.releaseDate)
    val moviePosterUrl = MovieHelper.processPosterUrl(movie.posterUrl)

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(8.dp)
                .clickable {
                    navController.navigate(Screen.MovieScreen.withArgs(movieId))
                }
        ){
            AsyncImage(
                model = moviePosterUrl,
                contentDescription = "${movieTitle}-Poster",
                error = painterResource(id = R.drawable.movie_poster_placeholder)
            )
            Column (modifier = Modifier.padding(start = 8.dp, end = 8.dp).width(140.dp))
            {
                Text(text = movie.title, style = MaterialTheme.typography.titleMedium, maxLines = 2, overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = movieYear, style = MaterialTheme.typography.titleSmall)
            }
        }
        HorizontalDivider()
    }
}