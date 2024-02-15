package com.moritz.movieappuitest.utils

import com.moritz.movieappuitest.BuildConfig

class TmdbCredentials {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"

        const val API_KEY = BuildConfig.apiKey

        const val POSTER_URL = "https://image.tmdb.org/t/p/w600_and_h900_bestv2"
        const val OTHER_IMAGE_URL = "https://image.tmdb.org/t/p/w200"

        const val POSTER_PLACEHOLDER_URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Portrait_placeholder_%282.3%29.svg/512px-Portrait_placeholder_%282.3%29.svg.png"
    }
}