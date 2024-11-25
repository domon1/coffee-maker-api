package com.komarov.coffee_maker_api.entity;

import com.komarov.coffee_maker_api.entity.food.FoodType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "food_item")
public class FoodItem extends Item {
    @ManyToOne
    @JoinColumn(name = "food_type_id")
    private FoodType foodType;
}
