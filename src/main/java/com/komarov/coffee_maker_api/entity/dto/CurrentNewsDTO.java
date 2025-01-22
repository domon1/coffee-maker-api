package com.komarov.coffee_maker_api.entity.dto;

import com.komarov.coffee_maker_api.entity.News;

public record CurrentNewsDTO(Long id, String name, String imageName, String newsText) {
    public CurrentNewsDTO(News news) {
        this(
                news.getId(),
                news.getName(),
                news.getImageName(),
                news.getNewsText()
        );
    }
}
