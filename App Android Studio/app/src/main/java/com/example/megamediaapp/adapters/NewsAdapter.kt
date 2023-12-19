package com.example.megamediaapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.example.megamediaapp.R
import com.example.megamediaapp.models.News

class NewsAdapter(
    private val newsList: List<News>,
    private val onNewsClickListener: OnNewsClickListener
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentNews = newsList[position]
        holder.bind(currentNews)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val newsTitleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val newsDescriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val newsImageView: ImageView = itemView.findViewById(R.id.imageView)
        private val playImageView: ImageView = itemView.findViewById(R.id.playImageView)

        fun bind(news: News) {
            newsTitleTextView.text = news.title
            newsDescriptionTextView.text = news.description

            if (news.imageUrl.isNotEmpty()) {
                loadImageFromUrl(news.imageUrl)
            } else {
                newsImageView.setImageResource(R.drawable.newsapp) // Usa un recurso específico para la imagen por defecto
            }

            // Gestiona el clic en la imagen para reproducir el video si la URL está disponible
            newsImageView.setOnClickListener {
                if (news.videoUrl.isNotEmpty()) {
                    onNewsClickListener.onNewsClick(news)
                }
            }

            // Muestra u oculta el icono de reproducción según la disponibilidad de la URL de video
            playImageView.visibility = if (news.videoUrl.isNotEmpty()) View.VISIBLE else View.GONE
        }

        private fun loadImageFromUrl(imageUrl: String) {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.baseline_crop_square_24) // Placeholder mientras se carga la imagen

            val glideUrl = GlideUrl(imageUrl, LazyHeaders.Builder().addHeader("User-Agent", "your-user-agent").build())

            Glide.with(itemView.context)
                .load(glideUrl)
                .apply(requestOptions)
                .into(newsImageView)
        }
    }

    // Interfaz para gestionar el clic en un elemento de la lista
    interface OnNewsClickListener {
        fun onNewsClick(news: News)
    }
}
