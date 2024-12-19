package com.patch4code.loglinemovieapp.features.core.presentation.components.filter_dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.patch4code.loglinemovieapp.features.core.presentation.components.BaseFilterChipRow

@Composable
fun FilterGenreSelection(
    availableGenres: Map<Int, String>,
    selectedGenres: SnapshotStateList<Int>
){

    BaseFilterChipRow(
        items = availableGenres.entries,
        labelProvider = { it.value },
        isSelected = {selectedGenres.contains(it.key)},
        onItemToggle = {
            if (selectedGenres.contains(it.key)) {
                selectedGenres.remove(it.key)
            } else {
                selectedGenres.add(it.key)
            }
        },
        hasAnyChip = true,
        anyChipLabel = "Any Genre",
        onAnyClick = { selectedGenres.clear() }
    )
}