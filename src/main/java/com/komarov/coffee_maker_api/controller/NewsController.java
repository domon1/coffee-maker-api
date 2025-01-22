package com.komarov.coffee_maker_api.controller;

import com.komarov.coffee_maker_api.entity.News;
import com.komarov.coffee_maker_api.entity.dto.CurrentNewsDTO;
import com.komarov.coffee_maker_api.entity.dto.NewsDTO;
import com.komarov.coffee_maker_api.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> createNews(@RequestBody News news){
        newsService.save(news);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<NewsDTO>> findAll(){
        return ResponseEntity.ok(newsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrentNewsDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(newsService.findById(id));
    }
}
