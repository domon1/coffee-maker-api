package com.komarov.coffee_maker_api.entity.dto;

import com.komarov.coffee_maker_api.entity.Order;

import java.util.List;

public record OrderDTO(Long id, Long userId, List<ItemDTO> items, Integer totalCost) {
    public OrderDTO(Order order) {
        this(
                order.getId(),
                order.getUserId(),
                order.getItems().stream()
                        .map(item -> new ItemDTO(
                                item.getId(),
                                item.getItemCategory().getId(),
                                item.getName(),
                                item.getImageName(),
                                item.getCost()
                        ))
                        .toList(),
                order.getTotalCost()
        );
    }
}
