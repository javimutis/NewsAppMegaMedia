package com.api.newsapp.repositories;

import com.api.newsapp.models.NewsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INewsRepository extends CrudRepository<NewsModel, Long>
{

}
