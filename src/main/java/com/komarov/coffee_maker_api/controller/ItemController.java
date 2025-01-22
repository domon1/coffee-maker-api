package com.komarov.coffee_maker_api.controller;

import com.komarov.coffee_maker_api.entity.Item;
import com.komarov.coffee_maker_api.entity.dto.CurrentItemDTO;
import com.komarov.coffee_maker_api.entity.dto.ItemDTO;
import com.komarov.coffee_maker_api.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Запрос для проверки работы запросов
    @GetMapping("/all")
    public ResponseEntity<List<ItemDTO>> getAllDrinks() {
        return ok(itemService.findAll());
    }

    // Все items по категории (еда, напитки)
    @GetMapping("/category/{id}")
    public ResponseEntity<List<ItemDTO>> getAllItemsByCategory(@PathVariable Long id) {
        return ok(itemService.findAllByCategoryId(id));
    }

    // Конкретный напиток
    @GetMapping("/{id}")
    public ResponseEntity<CurrentItemDTO> getItemById(@PathVariable Long id) {
        return ok(itemService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(@RequestBody Item item) {
        itemService.save(item);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
