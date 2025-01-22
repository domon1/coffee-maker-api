package com.komarov.coffee_maker_api.entity.dto;

import com.komarov.coffee_maker_api.entity.Item;

public record ItemDTO(Long id, Long categoryId, String name, String imageName, Integer cost) {
    public ItemDTO(Item item) {
        this(
                item.getId(),
                item.getItemCategory().getId(),
                item.getName(),
                item.getImageName(),
                item.getCost()
        );
    }
}
