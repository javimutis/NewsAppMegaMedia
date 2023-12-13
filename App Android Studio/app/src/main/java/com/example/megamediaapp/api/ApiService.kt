package com.example.megamediaapp.api

import com.example.megamediaapp.models.News
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    // Definición de la solicitud GET para obtener noticias desde la API.
    @GET("/news")
    fun getNews(): Call<List<News>>
}
