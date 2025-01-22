package com.komarov.coffee_maker_api.service;

import com.komarov.coffee_maker_api.entity.Item;
import com.komarov.coffee_maker_api.entity.Order;
import com.komarov.coffee_maker_api.entity.dto.CurrentItemDTO;
import com.komarov.coffee_maker_api.entity.dto.OrderDTO;
import com.komarov.coffee_maker_api.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemService itemService;
    private final UserService userService;

    public OrderService(OrderRepository orderRepository, ItemService itemService, UserService userService) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
        this.userService = userService;
    }

    public List<OrderDTO> findAllByUsername(String username) {
        List<Order> orders = orderRepository.findAllByUserId(userService.findByUsername(username).getId());
        orders.forEach(order -> order.setItems(itemService.findAllByOrderId(order.getId())));
        return convertToDTO(orders);
    }

    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        List<Item> items = itemService.findAllByOrderId(order.getId());
        order.setItems(items);
        return convertToDTO(order);
    }

    public void save(List<CurrentItemDTO> items, String username) {
        orderRepository.save(prepareOrder(items, username));
    }

    private OrderDTO convertToDTO(Order order) {
        return new OrderDTO(order);
    }

    private List<OrderDTO> convertToDTO(List<Order> orders) {
        return orders.stream().map(OrderDTO::new).toList();
    }

    private Order prepareOrder(List<CurrentItemDTO> items, String username) {
        List<Item> itemList = items.stream().map(itemService::convertToEntity).toList();
        Order order = new Order();
        order.setTotalCost(itemList.stream().mapToInt(Item::getCost).sum());
        order.setUserId(userService.findByUsername(username).getId());
        order.setItems(itemList);
        return order;
    }
}
