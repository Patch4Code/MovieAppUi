package com.moritz.movieappuitest.dataclasses

import android.os.Build
import androidx.annotation.RequiresApi

data class LoggedMovie(
    val movie: Movie,
    val date: String,
    val rating: Int
)

@RequiresApi(Build.VERSION_CODES.O)
var LoggedMoviesDummy: MutableList<LoggedMovie> = mutableListOf(
    LoggedMovie(
        Movie("Willy’s Wonderland", 643586,"2021-01-28","https://www.themoviedb.org/t/p/w600_and_h900_bestv2/keEnkeAvifw8NSEC4f6WsqeLJgF.jpg"),
        "2023-11-29",
        6
    ),
    LoggedMovie(
        Movie("Poor Things", 792307,"2023-01-01","https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jKyb0MKinNDbHF7WlBP4CE4KPAM.jpg"),
        "2024-01-30",
        9
    ),
    LoggedMovie(
        Movie("Old Boy", 670,"2004-09-02","https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pWDtjs568ZfOTMbURQBYuT4Qxka.jpg"),
        "2024-01-28",
        10
    ),
    LoggedMovie(
        Movie("Missing", 768362,"2023-02-23","https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wEOUYSU5Uf8J7152PT6jdb5233Y.jpg"),
        "2024-01-26",
        8
    ),
    LoggedMovie(
        Movie("Mad Max: Fury Road", 76341,"2015-05-14","https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8tZYtuWezp8JbcsvHYO0O46tFbo.jpg"),
        "2024-01-25",
        9
    ),
    LoggedMovie(
        Movie("The Unbearable Weight of Massive Talent", 648579,"2022-01-28","https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aqhLeieyTpTUKPOfZ3jzo2La0Mq.jpg"),
        "2023-12-29",
        7
    ),
)