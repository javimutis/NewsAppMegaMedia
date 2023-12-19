package com.example.megamediaapp.activities

import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.megamediaapp.R
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private var player: SimpleExoPlayer? = null
    private lateinit var videoUrl: String
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        // Inicializar la vista del reproductor de video
        playerView = findViewById(R.id.playerView)

        // Obtener la URL del video desde el Intent
        videoUrl = intent.getStringExtra("VIDEO_URL") ?: ""

        // Verificar si la URL del video no está vacía para inicializar el reproductor
        if (videoUrl.isNotEmpty()) {
            initializePlayer(videoUrl)
        } else {
            // Finalizar la actividad si no se proporcionó una URL válida
            finish()
        }
        // Configurar el botón de flecha hacia atrás para cerrar la actividad
        val backButton: ImageButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    // Método para inicializar el reproductor
    private fun initializePlayer(videoUrl: String) {
        player = SimpleExoPlayer.Builder(this).build()
        playerView.player = player

        val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
        player?.setMediaItem(mediaItem)

        // Restaurar el estado del reproductor
        player?.playWhenReady = playWhenReady
        player?.seekTo(currentWindow, playbackPosition)
        player?.prepare()
    }

    override fun onStart() {
        super.onStart()
        // Iniciar el reproductor si no está nulo
        if (player == null) {
            initializePlayer(videoUrl)
        }
    }

    override fun onResume() {
        super.onResume()
        // Iniciar el reproductor si no está nulo
        if (player == null) {
            initializePlayer(videoUrl)
        }
    }

    override fun onPause() {
        super.onPause()
        // Pausar y liberar el reproductor si no es nulo
        if (player != null) {
            playWhenReady = player?.playWhenReady ?: true
            playbackPosition = player?.currentPosition ?: 0L
            currentWindow = player?.currentWindowIndex ?: 0
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        // Liberar el reproductor al detener la actividad
        releasePlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Liberar el reproductor al destruir la actividad
        releasePlayer()
    }

    // Método para liberar el reproductor y sus recursos
    private fun releasePlayer() {
        player?.run {
            playWhenReady = false
            playbackPosition = currentPosition
            currentWindow = currentWindowIndex
            release()
        }
        player = null
    }
}
