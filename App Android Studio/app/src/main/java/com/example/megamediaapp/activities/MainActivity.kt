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
    var newsList: MutableList<News> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        newsAdapter = NewsAdapter(newsList, this)
        recyclerView.adapter = newsAdapter

        // Cargar los datos de las noticias al iniciar la actividad
        loadNewsData()
    }

    // Función para cargar los datos de la API o usar datos falsos si falla
    private fun loadNewsData() {
        val service: ApiService = RetrofitClient.instance

        val call: Call<List<News>> = service.getNews()
        call.enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                if (response.isSuccessful && response.body() != null) {
                    newsList.clear()
                    newsList.addAll(response.body()!!)
                    newsAdapter.notifyDataSetChanged()
                } else {
                    Log.e("MainActivity", "Error: ${response.code()}")
                    showErrorSnackbar("Error al cargar noticias, usando datos de prueba")
                    loadFakeNews()
                }
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                Log.e("MainActivity", "Error: ${t.message}")
                showErrorSnackbar("No se pudo conectar, usando datos de prueba")
                loadFakeNews()
            }
        })
    }

    // Datos falsos para demo o pantallazos
    private fun loadFakeNews() {
        val fakeNewsList = mutableListOf(
            News(
                id = 1,
                title = "Lanzamos una nueva aplicación",
                description = "La app permite leer noticias y ver videos en tiempo real.",
                imageUrl = "https://cdn.pixabay.com/photo/2015/12/11/09/30/mobile-phone-1087845_1280.jpg",
                videoUrl = "https://cdn.pixabay.com/video/2023/07/31/174003-850361299_large.mp4"
            ),
            News(
                id = 2,
                title = "Innovación en medios digitales",
                description = "Se introduce un reproductor de video integrado en cada noticia.",
                imageUrl = "https://cdn.pixabay.com/photo/2018/05/14/16/54/cyber-3400789_1280.jpg",
                videoUrl = "https://cdn.pixabay.com/video/2017/05/03/8957-215928665_large.mp4"
            ),
            News(
                id = 3,
                title = "Noticias destacadas del día",
                description = "Mantente informado con las noticias más relevantes del momento.",
                imageUrl = "https://cdn.pixabay.com/photo/2016/09/29/22/00/news-1703959_960_720.jpg",
                videoUrl = "https://cdn.pixabay.com/video/2019/12/05/29835-377621693_large.mp4"
            ),
            News(
                id = 4,
                title = "Cobertura en vivo de eventos",
                description = "Sigue los eventos importantes con nuestra cobertura en tiempo real.",
                imageUrl = "https://cdn.pixabay.com/photo/2022/01/21/00/38/youtube-icon-6953530_1280.jpg",
                videoUrl = "https://cdn.pixabay.com/video/2022/09/20/131916-751934616_large.mp4"
            )
        )

        newsList.clear()
        newsList.addAll(fakeNewsList)
        newsAdapter.notifyDataSetChanged()
    }

    private fun showErrorSnackbar(message: String) {
        val rootView: View = findViewById(android.R.id.content)
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onNewsClick(news: News) {
        if (news.videoUrl.isNotEmpty()) {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("VIDEO_URL", news.videoUrl)
            startActivity(intent)
        }
    }
}
