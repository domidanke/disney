package com.example.disney

import com.google.gson.annotations.SerializedName

data class DisneyCharacter (
    @SerializedName("_id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("imageUrl")
    val imageUrl: String?
)
