package com.api.newsapp;

import com.api.newsapp.models.NewsModel;
import com.api.newsapp.services.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
public class NewsServiceTest {

    @Autowired
    private NewsService newsService;

    @Test
    public void testGetNews() {
        List<NewsModel> newsList = newsService.getNews();
        assertNotNull(newsList);
        assertEquals(6, newsList.size()); // Verifica que haya 4 noticias en la base de datos
        // Verifica la estructura de cada noticia obtenida
        for (NewsModel news : newsList) {
            assertNotNull(news.getId());
            assertNotNull(news.getTitle());
            assertNotNull(news.getDescription());
            assertNotNull(news.getImageUrl());
            assertNotNull(news.getVideoUrl());
            // Agrega más aserciones según la estructura de tu modelo de noticia
        }
    }

    @Test
    public void testSaveNews() {
        NewsModel news = new NewsModel();
        news.setTitle("Nueva Noticia");
        news.setDescription("Descripción de la nueva noticia");
        news.setImageUrl("https://images.pexels.com/photos/302899/pexels-photo-302899.jpeg");
        news.setVideoUrl("https://cdn.coverr.co/videos/coverr-close-up-of-the-tamping-process-6214/1080p.mp4");

        NewsModel savedNews = newsService.saveNews(news);
        assertNotNull(savedNews);
        assertNotNull(savedNews.getId()); // Verifica que se haya generado un ID
        assertEquals("Nueva Noticia", savedNews.getTitle());
        // Agrega más aserciones según el comportamiento específico de guardar una noticia
    }

    @Test
    public void testGetById() {
        Optional<NewsModel> newsOptional = newsService.getById(1L);
        assertTrue(newsOptional.isPresent());
        NewsModel news = newsOptional.get();
        assertEquals("Día del periodista", news.getTitle());
        // Agrega más aserciones para verificar los detalles de la noticia específica
    }

    @Test
    public void testUpdateById() {
        Optional<NewsModel> newsOptional = newsService.getById(2L);
        assertTrue(newsOptional.isPresent());
        NewsModel news = newsOptional.get();
        news.setTitle("Título actualizado");
        news.setDescription("Descripción actualizada");

        NewsModel updatedNews = newsService.updateById(news, 2L);
        assertNotNull(updatedNews);
        assertEquals("Título actualizado", updatedNews.getTitle());
        assertEquals("Descripción actualizada", updatedNews.getDescription());
        // Agrega más aserciones según sea necesario
    }

    @Test
    public void testDeleteNews() {
        boolean isDeleted = newsService.deleteNews(4L);
        assertTrue(isDeleted);
        // Verifica que la noticia con ID 4 haya sido eliminada correctamente
    }

    @Test
    public void testGetNewsWithUrls() {
        List<NewsModel> newsListWithUrls = newsService.getNewsWithUrls();
        assertNotNull(newsListWithUrls);
        // Verifica que la lista no sea nula
        for (NewsModel news : newsListWithUrls) {
            assertNotNull(news.getId());
            assertNotNull(news.getTitle());
            assertNotNull(news.getDescription());
            assertNotNull(news.getImageUrl());
            assertNotNull(news.getVideoUrl());
            // Verifica que las URLs tengan un formato válido
            assertTrue(news.getImageUrl().startsWith("https://"));
            assertTrue(news.getVideoUrl().startsWith("https://"));
        }
    }

    // Puedes seguir escribiendo más pruebas para otras funcionalidades según tus necesidades
}
