package com.example.megamediaapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.megamediaapp.R
import com.example.megamediaapp.adapters.NewsAdapter
import com.example.megamediaapp.api.ApiService
import com.example.megamediaapp.api.RetrofitClient
import com.example.megamediaapp.models.News
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

        // Configurar RecyclerView y adaptador
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        newsAdapter = NewsAdapter(newsList, this)
        recyclerView.adapter = newsAdapter

        // Cargar datos de noticias al iniciar la actividad
        loadNewsData()
    }

    // Función para cargar datos de noticias desde la API usando Retrofit
    private fun loadNewsData() {
        val service: ApiService = RetrofitClient.instance

        val call: Call<List<News>> = service.getNews()
        call.enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        // Agregar noticias a la lista
                        newsList.addAll(it)
                        newsAdapter.notifyDataSetChanged()
                    }
                } else {
                    // Manejar errores en caso de respuesta no exitosa
                    Log.e("MainActivity", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                // Manejar el fallo en la carga de datos
                Log.e("MainActivity", "Error: ${t.message}")
            }
        })
    }

    override fun onNewsClick(news: News) {
        // Verificar si la URL del video está disponible
        if (news.videoUrl.isNotEmpty()) {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("VIDEO_URL", news.videoUrl)
            startActivity(intent)
        }
    }
}
