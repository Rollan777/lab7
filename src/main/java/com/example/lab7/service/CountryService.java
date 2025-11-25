package com.example.lab7.service;

import com.example.lab7.dto.CountryDto;
import com.example.lab7.entity.Country;
import com.example.lab7.mapper.CountryMapper;
import com.example.lab7.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryDto> getAll() {
        return countryMapper.toDtoList(countryRepository.findAll());
    }

    public CountryDto getById(Long id) {
        return countryRepository.findById(id)
                .map(countryMapper::toDto)
                .orElse(null);
    }

    public CountryDto create(CountryDto dto) {
        Country country = countryMapper.toEntity(dto);
        Country saved = countryRepository.save(country);
        return countryMapper.toDto(saved);
    }

    public CountryDto update(Long id, CountryDto dto) {
        if (!countryRepository.existsById(id)) {
            return null;
        }

        Country country = countryMapper.toEntity(dto);
        country.setId(id);

        Country updated = countryRepository.save(country);
        return countryMapper.toDto(updated);
    }

    public boolean delete(Long id) {
        if (!countryRepository.existsById(id)) {
            return false;
        }

        countryRepository.deleteById(id);
        return true;
    }
}
