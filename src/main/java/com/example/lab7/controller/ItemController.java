package com.example.lab7.controller;

import com.example.lab7.dto.ItemDto;
import com.example.lab7.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public ItemDto getById(@PathVariable Long id) {
        return itemService.getById(id);
    }

    @PostMapping
    public ItemDto create(@RequestBody ItemDto dto) {
        return itemService.create(dto);
    }

    @PutMapping("/{id}")
    public ItemDto update(@PathVariable Long id, @RequestBody ItemDto dto) {
        return itemService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return itemService.delete(id);
    }
}
