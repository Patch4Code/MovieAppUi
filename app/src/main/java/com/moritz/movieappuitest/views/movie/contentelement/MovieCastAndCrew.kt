package com.moritz.movieappuitest.views.movie.contentelement

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moritz.movieappuitest.dataclasses.MovieCredits

@Composable
fun MovieCastAndCrew(movieCredits: MovieCredits?){

    if (movieCredits != null) {
        if(!movieCredits.cast.isNullOrEmpty()){
            Text(
                text = "Cast",
                modifier = Modifier.padding(top = 16.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            LazyRow {
                items(movieCredits.cast) { castMember ->
                    CastMemberElement(castMember)
                    Spacer(modifier = Modifier.padding(4.dp))
                }
            }
        }
        if(!movieCredits.crew.isNullOrEmpty()){
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "Crew",
                modifier = Modifier.padding(top = 16.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            LazyRow {
                items(movieCredits.crew) { crewMember ->
                    CrewMemberElement(crewMember)
                    Spacer(modifier = Modifier.padding(4.dp))
                }
            }
        }
    }
}