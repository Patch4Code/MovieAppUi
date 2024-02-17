package com.moritz.movieappuitest.views.moviecards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ImageNotSupported
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.moritz.movieappuitest.Screen
import com.moritz.movieappuitest.dataclasses.Movie
import com.moritz.movieappuitest.utils.TmdbCredentials

@Composable
fun MovieSearchCard(navController: NavController, movie: Movie){

    val movieId = movie.id.toString()
    val title = movie.title
    val year: String = movie.releaseDate.takeIf { !it.isNullOrEmpty() }?.split("-")?.get(0) ?: "N/A"
    val posterUrl: String = (movie.posterUrl.takeIf { !it.isNullOrEmpty() }?.let { TmdbCredentials.POSTER_URL + it }
        ?: "")

    Column {
        Row (
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    navController.navigate(Screen.MovieScreen.withArgs(movieId))
                },

            ){
            if(posterUrl.isNotEmpty()){
                AsyncImage(
                    model = posterUrl,
                    contentDescription = "$title-Poster",
                    modifier = Modifier.padding(4.dp)
                )
            }else{
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .height(150.dp)
                        .width(50.dp),
                    shape = RectangleShape
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.ImageNotSupported,
                            contentDescription = "For $title no poster available",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
            Column {
                Text(
                    text = title,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    maxLines = 2
                )
                Text(
                    text = year,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.LightGray
                )
            }
        }
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}