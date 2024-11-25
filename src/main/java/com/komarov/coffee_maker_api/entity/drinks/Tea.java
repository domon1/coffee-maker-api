package com.komarov.coffee_maker_api.entity.drinks;

import com.komarov.coffee_maker_api.entity.DrinkItem;
import com.komarov.coffee_maker_api.entity.ingredients.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tea")
public class Tea extends DrinkItem {
    @ManyToOne
    @JoinColumn(name = "milk_id")
    private Milk milk;

    @ManyToOne
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;

    @ManyToOne
    @JoinColumn(name = "sugar_id")
    private Sugar sugar;

    @OneToMany
    @JoinColumn(name = "drink_id")
    private Set<Syrup> syrups;

    @OneToMany
    @JoinColumn(name = "drink_id")
    private Set<Sprinkling> sprinklings;
}
