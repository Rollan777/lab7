package com.example.lab7.controller;

import com.example.lab7.dto.FeatureDto;
import com.example.lab7.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/features")
@RequiredArgsConstructor
public class FeatureController {

    private final FeatureService featureService;

    @GetMapping
    public List<FeatureDto> getAll() {
        return featureService.getAll();
    }

    @GetMapping("/{id}")
    public FeatureDto getById(@PathVariable Long id) {
        return featureService.getById(id);
    }

    @PostMapping
    public FeatureDto create(@RequestBody FeatureDto dto) {
        return featureService.create(dto);
    }

    @PutMapping("/{id}")
    public FeatureDto update(@PathVariable Long id, @RequestBody FeatureDto dto) {
        return featureService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return featureService.delete(id);
    }
}
