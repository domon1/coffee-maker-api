package com.komarov.coffee_maker_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "image_name", nullable = false)
    private String imageName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer cost;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ItemCategory itemCategory;

    @ManyToMany(mappedBy = "items")
    private List<Order> orders = new ArrayList<>();
}
