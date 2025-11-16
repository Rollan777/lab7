package com.example.lab7.controller;

import com.example.lab7.dto.OwnerDto;
import com.example.lab7.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping
    public List<OwnerDto> getAll() {
        return ownerService.getAll();
    }

    @GetMapping("/{id}")
    public OwnerDto getById(@PathVariable Long id) {
        return ownerService.getById(id);
    }

    @PostMapping
    public OwnerDto create(@RequestBody OwnerDto dto) {
        return ownerService.create(dto);
    }

    @PutMapping("/{id}")
    public OwnerDto update(@PathVariable Long id, @RequestBody OwnerDto dto) {
        return ownerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return ownerService.delete(id);
    }
}
