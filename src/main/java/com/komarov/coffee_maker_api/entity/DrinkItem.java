package com.komarov.coffee_maker_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DrinkItem extends Item {
    @ManyToOne
    @JoinColumn(name = "type_id")
    private DrinkType drinkType;

    @ManyToOne
    @JoinColumn(name = "cup_size_id")
    private CupSize cupSize;

    @ManyToOne
    @JoinColumn(name = "sugar_id")
    private Sugar sugar;
}
