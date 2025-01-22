package com.komarov.coffee_maker_api.repository;

import com.komarov.coffee_maker_api.entity.Item;
import com.komarov.coffee_maker_api.service.ItemService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByItemCategory_Id(Long id);
    List<Item> findAllByOrders_Id(Long id);
}
