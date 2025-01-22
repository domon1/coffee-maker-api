package com.komarov.coffee_maker_api.controller;

import com.komarov.coffee_maker_api.entity.ItemCategory;
import com.komarov.coffee_maker_api.service.ItemCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/category")
public class ItemCategoryController {
    private final ItemCategoryService itemCategoryService;

    public ItemCategoryController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<ItemCategory>> getAll(){
        return ResponseEntity.ok(itemCategoryService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(@RequestBody ItemCategory category){
        itemCategoryService.save(category);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
