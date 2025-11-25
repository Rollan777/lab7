package com.example.lab7.controller;

import com.example.lab7.dto.CountryDto;
import com.example.lab7.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public List<CountryDto> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public CountryDto getById(@PathVariable Long id) {
        return countryService.getById(id);
    }

    @PostMapping
    public CountryDto create(@RequestBody CountryDto dto) {
        return countryService.create(dto);
    }

    @PutMapping("/{id}")
    public CountryDto update(@PathVariable Long id, @RequestBody CountryDto dto) {
        return countryService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return countryService.delete(id);
    }
}
