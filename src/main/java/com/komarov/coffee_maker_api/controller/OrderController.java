package com.komarov.coffee_maker_api.controller;

import com.komarov.coffee_maker_api.entity.dto.CurrentItemDTO;
import com.komarov.coffee_maker_api.entity.dto.OrderDTO;
import com.komarov.coffee_maker_api.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private  final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
        return ok(orderService.findById(id));
    }

    @GetMapping("/all/{username}")
    public ResponseEntity<List<OrderDTO>> findAllByUsername(@PathVariable String username){
        return ok(orderService.findAllByUsername(username));
    }

    @PostMapping("/save/{username}")
    public ResponseEntity<HttpStatus> save(@RequestBody List<CurrentItemDTO> items, @PathVariable String username){
        orderService.save(items, username);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
