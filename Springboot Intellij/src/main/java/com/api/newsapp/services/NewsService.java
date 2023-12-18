package com.api.newsapp.services;

import com.api.newsapp.models.NewsModel;
import com.api.newsapp.repositories.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    INewsRepository newsRepository;

    public List<NewsModel> getNews() {
        return (List<NewsModel>) newsRepository.findAll();
    }

    public NewsModel saveNews(NewsModel news) {
        try {
            return newsRepository.save(news);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la noticia: " + e.getMessage());
        }
    }

    public Optional<NewsModel> getById(Long id) {
        return newsRepository.findById(id);
    }
    public List<NewsModel> getNewsWithUrls() {
        List<NewsModel> newsList = (List<NewsModel>) newsRepository.findAll();
        for (NewsModel news : newsList) {
            if (news.getImageUrl() == null || news.getImageUrl().isEmpty()) {
                news.setImageUrl("https://example.com/images/" + news.getId());
            }
            if (news.getVideoUrl() == null || news.getVideoUrl().isEmpty()) {
                news.setVideoUrl("https://example.com/videos/" + news.getId());
            }
        }
        return newsList;
    }

    public NewsModel updateById(NewsModel request, Long id) {
        Optional<NewsModel> optionalNews = newsRepository.findById(id);
        if (optionalNews.isPresent()) {
            NewsModel newsModel = optionalNews.get();
            newsModel.setTitle(request.getTitle());
            newsModel.setDescription(request.getDescription());

            // Verificar y actualizar las URLs solo si se proporcionan nuevas URLs
            System.out.println("Received Image URL: " + request.getImageUrl());
            System.out.println("Received Video URL: " + request.getVideoUrl());

            if (request.getImageUrl() != null && !request.getImageUrl().isEmpty()) {
                newsModel.setImageUrl(request.getImageUrl());
            }
            if (request.getVideoUrl() != null && !request.getVideoUrl().isEmpty()) {
                newsModel.setVideoUrl(request.getVideoUrl());
            }

            System.out.println("Updated Image URL: " + newsModel.getImageUrl());
            System.out.println("Updated Video URL: " + newsModel.getVideoUrl());

            return newsRepository.save(newsModel);
        } else {
            throw new RuntimeException("Noticia no encontrada con ID: " + id);
        }
    }




    public boolean deleteNews(Long id) {
        try {
            newsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
