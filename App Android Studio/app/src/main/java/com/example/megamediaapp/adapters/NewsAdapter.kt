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

    // Método para crear una nueva vista para mostrar los elementos de la lista.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(itemView)
    }

    // Método para asociar datos a cada elemento de la vista (ViewHolder).
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentNews = newsList[position]
        holder.bind(currentNews)
    }

    // Método para obtener la cantidad de elementos en la lista.
    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val playImageView: ImageView = itemView.findViewById(R.id.playImageView)

        fun bind(news: News) {
            titleTextView.text = news.title
            descriptionTextView.text = news.description

            if (news.imageUrl.isNotEmpty()) {
                loadImageFromUrl(news.imageUrl)
            } else {
                imageView.setImageResource(R.drawable.baseline_crop_square_24)
            }

            // Clic en la imagen para reproducir el video
            imageView.setOnClickListener {
                if (news.videoUrl.isNotEmpty()) {
                    onNewsClickListener.onNewsClick(news)
                }
            }

            if (news.videoUrl.isNotEmpty()) {
                playImageView.visibility = View.VISIBLE
            } else {
                playImageView.visibility = View.GONE
            }
        }

        private fun loadImageFromUrl(imageUrl: String) {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.baseline_crop_square_24) // Placeholder mientras carga la imagen

            val glideUrl = GlideUrl(imageUrl, LazyHeaders.Builder().addHeader("User-Agent", "your-user-agent").build())

            Glide.with(itemView.context)
                .load(glideUrl)
                .apply(requestOptions)
                .into(imageView)
        }
    }

    // Interfaz para gestionar el clic en un elemento de la lista.
    interface OnNewsClickListener {
        fun onNewsClick(news: News)
    }
}
