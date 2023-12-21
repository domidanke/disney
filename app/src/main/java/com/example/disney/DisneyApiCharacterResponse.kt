package com.example.disney

class DisneyApiCharacterResponse (
    val info: DisneyApiInfo,
    val data: List<DisneyCharacter>
)

class DisneyApiInfo (
    val count: Int,
    val totalPages: Int,
    val previousPage: Int,
    val nextPage: String,
)
