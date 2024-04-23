package com.patch4code.loglinemovieapp.features.list.presentation.components.list.dialogs

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.patch4code.loglinemovieapp.R
import com.patch4code.loglinemovieapp.features.core.domain.model.Movie
import com.patch4code.loglinemovieapp.features.core.presentation.GeneralMovieSearchViewModel
import com.patch4code.loglinemovieapp.features.core.presentation.components.movie_search_dialog.MovieSearchDialog
import com.patch4code.loglinemovieapp.features.list.presentation.screen_list.ListViewModel

@Composable
fun AddMovieToListDialog(
    openAddMovieDialog: MutableState<Boolean>,
    listViewModel: ListViewModel,
    generalMovieSearchViewModel: GeneralMovieSearchViewModel = viewModel()
){

    if (!openAddMovieDialog.value) return

    val context = LocalContext.current
    val toastText = stringResource(id = R.string.toast_movie_already_on_list)

    val textInput = remember { mutableStateOf("") }
    val searchResult = generalMovieSearchViewModel.searchedMovies.observeAsState().value
    val selectedMovie = remember { mutableStateOf<Movie?>(null) }

    MovieSearchDialog(
        title = stringResource(id = R.string.list_add_movie_dialog_title),
        confirmText = stringResource(id = R.string.list_add_movie_dialog_confirm),
        textInput = textInput,
        selectedMovie = selectedMovie,
        searchResult = searchResult,
        generalMovieSearchViewModel = generalMovieSearchViewModel,
        onDismiss = {openAddMovieDialog.value = false},
        onConfirm = {
            selectedMovie.value?.let {movie->
                if (listViewModel.isMovieAlreadyOnList(movie)){
                    Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()
                }else{
                    listViewModel.addMovieToList(movie = movie)
                    openAddMovieDialog.value = false
                }
            }
        }
    )
}