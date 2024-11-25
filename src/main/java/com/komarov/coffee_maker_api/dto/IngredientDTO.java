package com.komarov.coffee_maker_api.dto;

public record IngredientDTO(
        Long id,
        String name,
        Integer cost,
        String type) {

//    public IngredientDTO(Ingredient ingredient) {
//        this(
//                ingredient.getId(),
//                ingredient.getName(),
//                ingredient.getCost(),
//                ingredient.getIngredientType().getName());
//    }
}
