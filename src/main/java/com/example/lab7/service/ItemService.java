package com.example.lab7.service;

import com.example.lab7.dto.ItemDto;
import com.example.lab7.entity.Country;
import com.example.lab7.entity.Item;
import com.example.lab7.mapper.ItemMapper;
import com.example.lab7.repository.CountryRepository;
import com.example.lab7.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CountryRepository countryRepository;
    private final ItemMapper itemMapper;

    public List<ItemDto> getAll() {
        return itemMapper.toDtoList(itemRepository.findAll());
    }

    public ItemDto getById(Long id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDto)
                .orElse(null);
    }

    public ItemDto create(ItemDto dto) {

        // manufacturerId MUST exist
        Country manufacturer = countryRepository.findById(dto.getManufacturerId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        Item item = itemMapper.toEntity(dto);
        item.setManufacturer(manufacturer);

        Item saved = itemRepository.save(item);
        return itemMapper.toDto(saved);
    }

    public ItemDto update(Long id, ItemDto dto) {

        if (!itemRepository.existsById(id)) {
            return null;
        }

        Country manufacturer = countryRepository.findById(dto.getManufacturerId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        Item item = itemMapper.toEntity(dto);
        item.setId(id);
        item.setManufacturer(manufacturer);

        Item updated = itemRepository.save(item);
        return itemMapper.toDto(updated);
    }

    public boolean delete(Long id) {
        if (!itemRepository.existsById(id)) {
            return false;
        }

        itemRepository.deleteById(id);
        return true;
    }
}
