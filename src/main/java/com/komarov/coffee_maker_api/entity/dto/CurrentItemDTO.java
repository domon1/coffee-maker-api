package com.komarov.coffee_maker_api.entity.dto;

import com.komarov.coffee_maker_api.entity.Item;

public record CurrentItemDTO(Long id,
                             String name,
                             String imageName,
                             Integer cost,
                             String description) {
    public CurrentItemDTO(Item item) {
        this(
                item.getId(),
                item.getName(),
                item.getImageName(),
                item.getCost(),
                item.getDescription()
        );
    }
}
