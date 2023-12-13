package com.api.newsapp.models;

import jakarta.persistence.*;


@Entity
@Table(name = "news")
public class NewsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único de la noticia

    @Column(nullable = false)
    private String title; // Título de la noticia

    @Column(nullable = false)
    private String description; // Descripción de la noticia

    @Column(nullable = false, columnDefinition = "TEXT")
    private String imageUrl; // URL de la imagen asociada a la noticia

    @Column(nullable = false, columnDefinition = "TEXT")
    private String videoUrl; // URL del video asociado a la noticia

    // Métodos getter y setter para cada atributo de la noticia

    public Long getId() {
        return id; // Devuelve el ID de la noticia
    }

    public void setId(Long id) {
        this.id = id; // Establece el ID de la noticia
    }

    public String getTitle() {
        return title; // Devuelve el título de la noticia
    }

    public void setTitle(String title) {
        this.title = title; // Establece el título de la noticia
    }

    public String getDescription() {
        return description; // Devuelve la descripción de la noticia
    }

    public void setDescription(String description) {
        this.description = description; // Establece la descripción de la noticia
    }

    public String getImageUrl() {
        return imageUrl; // Devuelve la URL de la imagen asociada a la noticia
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl; // Establece la URL de la imagen asociada a la noticia
    }

    public String getVideoUrl() {
        return videoUrl; // Devuelve la URL del video asociado a la noticia
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl; // Establece la URL del video asociado a la noticia
    }
}
