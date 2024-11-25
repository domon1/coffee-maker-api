package com.komarov.coffee_maker_api.entity.ingredients;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sugar")
public class Sugar extends Ingredient{
    @Column(nullable = false)
    private String type;
}
