package com.patch4code.loglinemovieapp.features.movie.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.patch4code.loglinemovieapp.features.core.domain.model.Movie
import com.patch4code.loglinemovieapp.features.movie.domain.model.CountryProviders
import com.patch4code.loglinemovieapp.features.movie.domain.model.MovieCredits
import com.patch4code.loglinemovieapp.features.movie.domain.model.MovieDetails
import com.patch4code.loglinemovieapp.features.movie.domain.model.MovieVideo
import com.patch4code.loglinemovieapp.features.movie.presentation.components.cast_and_crew.MovieCastAndCrew
import com.patch4code.loglinemovieapp.features.movie.presentation.components.header.MovieHeader
import com.patch4code.loglinemovieapp.features.movie.presentation.components.watch_providers.MovieWatchProviders
import com.patch4code.loglinemovieapp.features.movie.presentation.screen_movie.MovieViewModel
import com.patch4code.loglinemovieapp.room_database.LoglineDatabase

/**
 * APACHE LICENSE, VERSION 2.0 (https://www.apache.org/licenses/LICENSE-2.0)
 *
 * MovieContent - Composable function that displays the content of a movie including header-section
 * (with poster, title, year, length and MovieHeaderToolbar), description, rating, genres, featuresBar
 * (with trailer-, reviews- and share-button), watch-providers, cast and crew, more details, more movies
 * like the current and the source reference.
 *
 * @author Patch4Code
 */
@Composable
fun MovieContent(
    movieDetails: MovieDetails?,
    movieCredits: MovieCredits?,
    collectionMovies: List<Movie>?,
    movieVideo: MovieVideo?,
    movieProviders: CountryProviders?,
    watchCountry: String?,
    navController: NavController,
    movieViewModel: MovieViewModel,
    db: LoglineDatabase
) {
    val openPosterPopup = remember { mutableStateOf(false)  }

    LazyColumn (modifier = Modifier.padding(16.dp)){
        item {
            MovieHeader(
                movieDetails = movieDetails,
                movieViewModel = movieViewModel,
                db = db,
                onPosterClick = { openPosterPopup.value = true }
            )
            MovieDescription(movieDetails?.tagline, movieDetails?.overview)
            MovieRatings(movieDetails?.voteAverage)
            MovieGenres(movieDetails?.genres)

            MovieFeaturesBar(movieVideo, movieDetails, navController)
            MovieWatchProviders(movieProviders, watchCountry, movieDetails?.id)

            MovieCastAndCrew(movieCredits, navController)
            MovieMoreDetails(movieDetails)
            MovieMoreLikeThis(navController, collectionMovies, movieDetails?.title)
            MovieSourceReference()
        }
    }
    MoviePosterPopup(openPosterPopup.value, movieDetails, onPosterPopupClose = {openPosterPopup.value = false})
}