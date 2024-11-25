package com.komarov.coffee_maker_api.dto;

import java.util.List;

public record DrinkDTO(
        Long id,
        String name,
        String description,
        Integer cost,
        String groupName,
        String drinkType,
        Integer cupSize,
        List<IngredientDTO> ingredients) {

//    public DrinkDTO(DrinkItem drinkItem, List<IngredientDTO> ingredients) {
//        this(
//                drinkItem.getId(),
//                drinkItem.getName(),
//                drinkItem.getDescription(),
//                drinkItem.getCost(),
//                drinkItem.getItemGroup().getName(),
//                drinkItem.getDrinkType().getName(),
//                drinkItem.getCupSize().getSize(),
//                ingredients);
//    }

}
