package com.komarov.coffee_maker_api.entity.dto;

import com.komarov.coffee_maker_api.entity.News;

public record NewsDTO(Long id, String name, String imageName) {
    public NewsDTO(News news) {
        this(
                news.getId(),
                news.getName(),
                news.getImageName()
        );
    }
}
