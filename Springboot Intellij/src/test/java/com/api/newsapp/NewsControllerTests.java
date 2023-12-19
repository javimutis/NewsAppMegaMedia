package com.api.newsapp;

import com.api.newsapp.controllers.NewsController;
import com.api.newsapp.models.NewsModel;
import com.api.newsapp.services.NewsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NewsControllerTests {

    @Mock
    private NewsService newsService;

    @InjectMocks
    private NewsController newsController;

    @Test
    public void testGetNews_Success() {
        // Simular la lista de noticias
        List<NewsModel> newsList = new ArrayList<>();
        // Agregar algunas noticias ficticias a la lista

        when(newsService.getNews()).thenReturn(newsList);

        // Realizar la llamada al controlador
        List<NewsModel> result = newsController.getNews();

        // Verificar si se obtuvieron las noticias correctamente
        assertEquals(newsList, result);
    }

    @Test
    public void testSaveNews_Success() {
        // Crear una noticia ficticia para guardar
        NewsModel newsToSave = new NewsModel();
        newsToSave.setId(1L);
        newsToSave.setTitle("Title");
        newsToSave.setDescription("Description");
        newsToSave.setImageUrl("Image URL");
        newsToSave.setVideoUrl("Video URL");

        when(newsService.saveNews(any())).thenReturn(newsToSave);

        // Realizar la llamada al controlador
        ResponseEntity<?> responseEntity = newsController.saveNews(newsToSave);

        // Verificar si la noticia se guardó correctamente
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(newsToSave, responseEntity.getBody());
    }

    @Test
    public void testGetNewsById_Success() {
        // Crear una noticia ficticia para obtener por ID
        NewsModel newsById = new NewsModel();
        newsById.setId(1L);
        newsById.setTitle("Title");
        newsById.setDescription("Description");
        newsById.setImageUrl("Image URL");
        newsById.setVideoUrl("Video URL");

        when(newsService.getById(1L)).thenReturn(Optional.of(newsById));

        // Realizar la llamada al controlador
        Optional<NewsModel> result = newsController.getNewsById(1L);

        // Verificar si se obtuvo la noticia por ID correctamente
        assertTrue(result.isPresent());
        assertEquals(newsById, result.get());
    }

    @Test
    public void testUpdateNewsById_Success() {
        // Crear una noticia ficticia para actualizar por ID
        NewsModel newsToUpdate = new NewsModel();
        newsToUpdate.setId(1L);
        newsToUpdate.setTitle("Updated Title");
        newsToUpdate.setDescription("Updated Description");
        newsToUpdate.setImageUrl("Updated Image URL");
        newsToUpdate.setVideoUrl("Updated Video URL");

        when(newsService.updateById(any(), anyLong())).thenReturn(newsToUpdate);

        // Realizar la llamada al controlador
        NewsModel result = newsController.updateNewsById(newsToUpdate, 1L);

        // Verificar si se actualizó la noticia por ID correctamente
        assertNotNull(result);
        assertEquals(newsToUpdate.getTitle(), result.getTitle());
        assertEquals(newsToUpdate.getDescription(), result.getDescription());
        assertEquals(newsToUpdate.getImageUrl(), result.getImageUrl());
        assertEquals(newsToUpdate.getVideoUrl(), result.getVideoUrl());
    }

    @Test
    public void testDeleteNewsById_Success() {
        when(newsService.deleteNews(1L)).thenReturn(true);

        // Realizar la llamada al controlador
        String result = newsController.deleteById(1L);

        // Verificar si se eliminó la noticia por ID correctamente
        assertEquals("Deleted1", result);
    }
}
