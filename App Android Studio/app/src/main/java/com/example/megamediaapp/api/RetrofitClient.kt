package com.example.megamediaapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // Definir la URL base de la API
    private const val BASE_URL = "https://springgcp-407920.rj.r.appspot.com"

    // Crear una instancia única de Retrofit para interactuar con la API
    val instance: ApiService by lazy {
        // Configurar Retrofit con la URL base y el convertidor de JSON a objetos
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Usar Gson para convertir JSON a objetos
            .build()

        // Crear e inicializar el servicio ApiService utilizando Retrofit
        retrofit.create(ApiService::class.java)
    }
}
