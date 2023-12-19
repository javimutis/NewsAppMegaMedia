package com.example.megamediaapp.models

// Clase de modelo que representa una noticia (News)
data class News(
    val id: Long,
    val title: String,
    val description: String,
    val imageUrl: String,
    val videoUrl: String
)
