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

    public NewsModel updateById(NewsModel request, Long id) {
        NewsModel newsModel = newsRepository.findById(id).orElseThrow(() -> new RuntimeException("Noticia no encontrada con ID: " + id));
        newsModel.setTitle(request.getTitle());
        newsModel.setDescription(request.getDescription());
        newsRepository.save(newsModel);
        return newsModel;
    }

    public boolean deleteNews(Long id) {
        try {
            newsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<NewsModel> getNewsWithUrls() {
        List<NewsModel> newsList = (List<NewsModel>) newsRepository.findAll();
        for (NewsModel news : newsList) {
            news.setImageUrl("https://example.com/images/" + news.getId());
            news.setVideoUrl("https://example.com/videos/" + news.getId());
        }
        return newsList;
    }
}
