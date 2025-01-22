package com.komarov.coffee_maker_api.service;

import com.komarov.coffee_maker_api.entity.Item;
import com.komarov.coffee_maker_api.entity.dto.CurrentItemDTO;
import com.komarov.coffee_maker_api.entity.dto.ItemDTO;
import com.komarov.coffee_maker_api.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public CurrentItemDTO findById(Long id) {
        return convertToDTO(itemRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public List<ItemDTO> findAll() {
        return convertToDTO(itemRepository.findAll());
    }

    public List<ItemDTO> findAllByCategoryId(Long id) {
        return convertToDTO(itemRepository.findAllByItemCategory_Id(id));
    }

    public List<Item> findAllByOrderId(Long id) {
        return itemRepository.findAllByOrders_Id(id);
    }

    private CurrentItemDTO convertToDTO(Item item) {
        return new CurrentItemDTO(item);
    }

    public Item convertToEntity(CurrentItemDTO currentItem) {
        return itemRepository.findById(currentItem.id()).orElseThrow(RuntimeException::new);
    }

    private List<ItemDTO> convertToDTO(List<Item> items) {
        return items.stream().map(ItemDTO::new).toList();
    }

    public Item convertToEntity(ItemDTO item) {
        return itemRepository.findById(item.id()).orElseThrow(RuntimeException::new);
    }

    public void save(Item item) {
        itemRepository.save(item);
    }
}
