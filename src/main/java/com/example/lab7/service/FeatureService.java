package com.example.lab7.service;

import com.example.lab7.dto.FeatureDto;
import com.example.lab7.entity.Feature;
import com.example.lab7.mapper.FeatureMapper;
import com.example.lab7.repository.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeatureService {

    private final FeatureRepository featureRepository;
    private final FeatureMapper featureMapper;

    public List<FeatureDto> getAll() {
        return featureMapper.toDtoList(featureRepository.findAll());
    }

    public FeatureDto getById(Long id) {
        return featureRepository.findById(id)
                .map(featureMapper::toDto)
                .orElse(null);
    }

    public FeatureDto create(FeatureDto dto) {
        Feature feature = featureMapper.toEntity(dto);
        Feature saved = featureRepository.save(feature);
        return featureMapper.toDto(saved);
    }

    public FeatureDto update(Long id, FeatureDto dto) {
        if (!featureRepository.existsById(id)) {
            return null;
        }
        Feature feature = featureMapper.toEntity(dto);
        feature.setId(id);
        Feature updated = featureRepository.save(feature);
        return featureMapper.toDto(updated);
    }

    public boolean delete(Long id) {
        if (!featureRepository.existsById(id)) {
            return false;
        }
        featureRepository.deleteById(id);
        return true;
    }
}
