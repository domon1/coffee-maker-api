package com.komarov.coffee_maker_api.entity;

import com.komarov.coffee_maker_api.entity.drinks.CupSize;
import com.komarov.coffee_maker_api.entity.drinks.DrinkType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class DrinkItem extends Item {
    @ManyToOne
    @JoinColumn(name = "cup_size_id")
    private CupSize cupSize;

    @ManyToOne
    @JoinColumn(name = "drink_type_id")
    private DrinkType drinkType;
}
