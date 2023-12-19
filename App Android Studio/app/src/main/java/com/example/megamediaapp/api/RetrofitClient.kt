package com.example.megamediaapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Objeto Singleton para configurar y obtener una instancia de Retrofit
object RetrofitClient {
    // URL base de la API
    private const val BASE_URL = "https://springgcp-407920.rj.r.appspot.com"

    // Inicialización perezosa de la instancia de ApiService
    val instance: ApiService by lazy {
        // Configuración de Retrofit con la URL base y el convertidor de Gson
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Conversión de JSON a objetos utilizando Gson
            .build()

        // Creación e inicialización del servicio ApiService utilizando Retrofit
        retrofit.create(ApiService::class.java)
    }
}
