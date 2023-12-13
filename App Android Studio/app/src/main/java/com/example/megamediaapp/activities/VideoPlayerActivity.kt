package com.example.megamediaapp.activities

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.megamediaapp.R
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private var player: SimpleExoPlayer? = null
    private lateinit var videoUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        // Inicialización de vistas y obtención de la URL del video del Intent
        playerView = findViewById(R.id.playerView)

        // Obtener la URL del video de los extras del Intent
        videoUrl = intent.getStringExtra("VIDEO_URL") ?: ""

        // Verificar si se proporcionó una URL válida del video
        if (videoUrl.isNotEmpty()) {
            initializePlayer(videoUrl)
        } else {
            finish() // Finalizar la actividad si no hay URL de video
        }
    }

    private fun initializePlayer(videoUrl: String) {
        try {
            // Creación del reproductor ExoPlayer y asignación a la vista PlayerView
            player = SimpleExoPlayer.Builder(this).build()
            playerView.player = player

            // Creación del MediaItem con la URL del video
            val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))

            // Preparar el reproductor con el MediaItem y reproducir el video
            player?.setMediaItem(mediaItem)
            player?.prepare()
            player?.play()
        } catch (e: Exception) {
            e.printStackTrace()
            // Manejar la excepción aquí (puedes mostrar un mensaje de error, registrar el error, etc.)
        }
    }

    override fun onStop() {
        super.onStop()
        player?.release() // Liberar recursos del reproductor al detener la actividad
    }
}
