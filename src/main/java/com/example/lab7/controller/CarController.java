package com.example.lab7.controller;

import com.example.lab7.dto.CarDto;
import com.example.lab7.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarDto> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public CarDto getById(@PathVariable Long id) {
        return carService.getById(id);
    }

    @PostMapping
    public CarDto create(@RequestBody CarDto dto) {
        return carService.create(dto);
    }

    @PutMapping("/{id}")
    public CarDto update(@PathVariable Long id, @RequestBody CarDto dto) {
        return carService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return carService.delete(id);
    }
}
