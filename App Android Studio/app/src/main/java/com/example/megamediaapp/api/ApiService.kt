package com.example.megamediaapp.api

import com.example.megamediaapp.models.News
import retrofit2.Call
import retrofit2.http.GET

// Interfaz que define las operaciones de la API para obtener noticias
interface ApiService {

    // Método GET para obtener la lista de noticias desde el servidor
    @GET("/news")
    fun getNews(): Call<List<News>>
}
