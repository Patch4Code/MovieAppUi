package com.patch4code.loglinemovieapp.features.profile.presentation.components.profile_edit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.patch4code.loglinemovieapp.R
import com.patch4code.loglinemovieapp.features.core.domain.model.Movie
import com.patch4code.loglinemovieapp.features.core.presentation.utils.TmdbCredentials
import com.patch4code.loglinemovieapp.features.profile.domain.model.UserProfile
import com.patch4code.loglinemovieapp.features.profile.presentation.components.profile_edit.dialogs.SelectFavMovieDialog
import com.patch4code.loglinemovieapp.features.profile.presentation.screen_profile.ProfileViewModel

/**
 * GNU GENERAL PUBLIC LICENSE, VERSION 3.0 (https://www.gnu.org/licenses/gpl-3.0.html)
 *
 * ProfileEditFavMoviesSection - Composable function for editing the favorite movies  of the user profile.
 *
 * @author Patch4Code
 */
@Composable
fun ProfileEditFavMoviesSection(userProfile:UserProfile?, profileViewModel: ProfileViewModel){

    val openSelectFavMovieDialog = remember { mutableStateOf(false)  }
    val favMovieClickedIndex = remember { mutableIntStateOf(-1 ) }

    HorizontalDivider(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

    Text(text = stringResource(id = R.string.favourite_movies_title2), style = MaterialTheme.typography.labelLarge, modifier = Modifier.padding(8.dp))
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, bottom = 8.dp),
    ){
        userProfile?.favouriteMovies?.forEachIndexed { index, movie ->
            val movieId = movie.id
            val moviePosterUrl = TmdbCredentials.POSTER_URL + movie.posterUrl
            Box(modifier = Modifier.weight(1f)){
                // movie poster, if no movie is selected open SelectFavMovieDialog on click
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(enabled = movieId < 0) {
                            favMovieClickedIndex.intValue = index
                            openSelectFavMovieDialog.value = true
                        },
                    model = moviePosterUrl,
                    contentDescription = movie.title,
                    error = painterResource(id = R.drawable.add_favourite_movie)
                )
                // remove fav movie button (little x in the right upper corner of the poster)
                if(movieId >= 0){
                    FilledTonalIconButton(
                        onClick = { profileViewModel.setFavMovieAtIndex(index, Movie()) },
                        modifier = Modifier.align(Alignment.TopEnd).padding(2.dp).size(20.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = stringResource(id = R.string.delete_fav_movie_icon_description))
                    }
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }

    SelectFavMovieDialog(openSelectFavMovieDialog, favMovieClickedIndex, profileViewModel)
}