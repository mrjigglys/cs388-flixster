package com.example.flixster

import com.google.gson.annotations.SerializedName

// SerializedName tags MUST match the JSON response for the object to correctly parse with the gson library.
class Movie {
    @SerializedName("original_title")
    var title: String? = null

    @SerializedName("overview")
    var description: String? = null

    @SerializedName("poster_path")
    var movieImageUrl: String? = null
}