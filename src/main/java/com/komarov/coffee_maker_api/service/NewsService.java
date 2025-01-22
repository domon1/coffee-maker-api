package com.komarov.coffee_maker_api.service;

import com.komarov.coffee_maker_api.entity.News;
import com.komarov.coffee_maker_api.entity.dto.CurrentNewsDTO;
import com.komarov.coffee_maker_api.entity.dto.NewsDTO;
import com.komarov.coffee_maker_api.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<NewsDTO> findAll(){
        return convertToDTO(newsRepository.findAll());
    }

    public CurrentNewsDTO findById(Long id) {
        return convertToDTO(newsRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    private CurrentNewsDTO convertToDTO(News news) {
        return new CurrentNewsDTO(news);
    }

    private List<NewsDTO> convertToDTO(List<News> newsList) {
        return newsList.stream().map(NewsDTO::new).toList();
    }

    public void save(News news) {
        newsRepository.save(news);
    }
}
