package com.example.megamediaapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.megamediaapp.R
import com.example.megamediaapp.adapters.NewsAdapter
import com.example.megamediaapp.api.ApiService
import com.example.megamediaapp.api.RetrofitClient
import com.example.megamediaapp.models.News
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), NewsAdapter.OnNewsClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private var newsList: MutableList<News> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enlazar el RecyclerView desde el layout y configurar su diseño
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Crear el adaptador para las noticias y asignarlo al RecyclerView
        newsAdapter = NewsAdapter(newsList, this)
        recyclerView.adapter = newsAdapter

        // Cargar los datos de las noticias al iniciar la actividad
        loadNewsData()
    }

    // Función para cargar los datos de las noticias desde la API
    private fun loadNewsData() {
        val service: ApiService = RetrofitClient.instance

        // Realizar la solicitud para obtener las noticias
        val call: Call<List<News>> = service.getNews()
        call.enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        // Agregar las noticias a la lista y notificar al adaptador
                        newsList.addAll(it)
                        newsAdapter.notifyDataSetChanged()
                    }
                } else {
                    // Manejar errores en caso de respuesta no exitosa
                    Log.e("MainActivity", "Error: ${response.code()}")
                    showErrorSnackbar("Error al cargar noticias")
                }
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                // Manejar el fallo en la carga de datos
                Log.e("MainActivity", "Error: ${t.message}")
                showErrorSnackbar("Error de conexión")
            }
        })
    }

    // Función para mostrar un Snackbar de error con un mensaje específico
    private fun showErrorSnackbar(message: String) {
        val rootView: View = findViewById(android.R.id.content)
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()
    }

    // Función para manejar el clic en una noticia para reproducir el video si está disponible
    override fun onNewsClick(news: News) {
        if (news.videoUrl.isNotEmpty()) {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("VIDEO_URL", news.videoUrl)
            startActivity(intent)
        }
    }
}
