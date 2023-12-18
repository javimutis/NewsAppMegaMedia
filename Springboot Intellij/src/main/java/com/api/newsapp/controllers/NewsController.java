package com.api.newsapp.controllers;

import com.api.newsapp.models.NewsModel;
import com.api.newsapp.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<NewsModel> getNews() {
        return newsService.getNews();
    }

    @PostMapping
    public ResponseEntity<?> saveNews(@RequestBody NewsModel news) {
        try {
            NewsModel savedNews = newsService.saveNews(news);
            return ResponseEntity.ok(savedNews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la noticia: " + e.getMessage());
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<NewsModel> getNewsById(@PathVariable("id") Long id) {
        return newsService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public NewsModel updateNewsById(@RequestBody NewsModel request, @PathVariable Long id) {
        return newsService.updateById(request, id);
    }


    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = newsService.deleteNews(id);
        if (ok) {
            return "Deleted" + id;
        } else {
            return "Not Deleted" + id;
        }
    }

    @GetMapping("/withUrls")
    public List<NewsModel> getNewsWithUrls() {
        return newsService.getNewsWithUrls();
    }
}
