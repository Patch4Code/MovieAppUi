package com.patch4code.loglinemovieapp.features.list.presentation.components.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.patch4code.loglinemovieapp.features.core.domain.model.FilterOptions
import com.patch4code.loglinemovieapp.features.core.domain.model.SortOption
import com.patch4code.loglinemovieapp.features.core.presentation.components.swipe.SwipeToDeleteContainer
import com.patch4code.loglinemovieapp.features.list.domain.model.MovieInList
import com.patch4code.loglinemovieapp.features.list.presentation.components.list.dialogs.DeleteMovieFromListDialog
import com.patch4code.loglinemovieapp.features.list.presentation.components.list.items.ListItem
import com.patch4code.loglinemovieapp.features.list.presentation.screen_list.ListViewModel
import com.patch4code.loglinemovieapp.features.list.presentation.utils.ListDialogsExtensions.onDeleteMovieFromList

/**
 * GNU GENERAL PUBLIC LICENSE, VERSION 3.0 (https://www.gnu.org/licenses/gpl-3.0.html)
 *
 * ListContent - Composable function representing the content of a movie list.
 * Includes a header section with list title, makePublic-button and listSettings-button.
 * Below that is a LazyColumn with the list items which provide swipe to delete functionality.
 *
 * @author Patch4Code
 */
@Composable
fun ListContent(
    moviesInList: List<MovieInList>,
    navController: NavController,
    listViewModel: ListViewModel,
    selectedSortOption: SortOption,
    selectedFilterOptions: FilterOptions
){

    val openDeleteMovieDialog = remember { mutableStateOf(false)  }
    val movieToDelete = remember { mutableStateOf<MovieInList?>(null) }
    val deletingStates = remember { mutableStateMapOf<MovieInList, Boolean>() }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)
    ){
        itemsIndexed(
            items = moviesInList,
            key = { _, item -> item.hashCode() }
        ) { index, movieInList ->
            val isDeleting = deletingStates[movieInList] ?: false

            SwipeToDeleteContainer(
                item = movieInList,
                isDeleting = isDeleting,
                onDelete = {
                    movieToDelete.value = movieInList
                    openDeleteMovieDialog.value = true
                    deletingStates[movieInList] = true
                }
            ){_, deleting ->
                ListItem(navController, movieInList, Modifier.alpha(if (deleting) 0f else 1f))
            }
            if(index < moviesInList.lastIndex + 1){
                HorizontalDivider()
            }
        }
    }

    DeleteMovieFromListDialog(openDeleteMovieDialog = openDeleteMovieDialog.value,
        onDelete = { listViewModel.onDeleteMovieFromList(movieToDelete, openDeleteMovieDialog, selectedSortOption, selectedFilterOptions) },
        onCancel = {
            movieToDelete.value?.let {
                deletingStates[it] = false
            }
            openDeleteMovieDialog.value = false
        }
    )
}