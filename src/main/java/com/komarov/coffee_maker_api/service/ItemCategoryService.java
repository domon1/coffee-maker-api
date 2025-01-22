package com.komarov.coffee_maker_api.service;

import com.komarov.coffee_maker_api.entity.ItemCategory;
import com.komarov.coffee_maker_api.repository.ItemCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryService {
    private final ItemCategoryRepository itemCategoryRepository;

    public ItemCategoryService(ItemCategoryRepository itemCategoryRepository) {
        this.itemCategoryRepository = itemCategoryRepository;
    }

    public List<ItemCategory> getAll(){
        return itemCategoryRepository.findAll();
    }

    public ItemCategory save(ItemCategory itemCategory){
        return itemCategoryRepository.save(itemCategory);
    }
}
