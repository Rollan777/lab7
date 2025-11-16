package com.example.lab7.service;

import com.example.lab7.dto.OwnerDto;
import com.example.lab7.entity.Owner;
import com.example.lab7.mapper.OwnerMapper;
import com.example.lab7.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public List<OwnerDto> getAll() {
        return ownerMapper.toDtoList(ownerRepository.findAll());
    }

    public OwnerDto getById(Long id) {
        return ownerRepository.findById(id)
                .map(ownerMapper::toDto)
                .orElse(null);
    }

    public OwnerDto create(OwnerDto dto) {
        Owner owner = ownerMapper.toEntity(dto);
        Owner saved = ownerRepository.save(owner);
        return ownerMapper.toDto(saved);
    }

    public OwnerDto update(Long id, OwnerDto dto) {
        if (!ownerRepository.existsById(id)) {
            return null;
        }
        Owner owner = ownerMapper.toEntity(dto);
        owner.setId(id);
        Owner updated = ownerRepository.save(owner);
        return ownerMapper.toDto(updated);
    }

    public boolean delete(Long id) {
        if (!ownerRepository.existsById(id)) {
            return false;
        }
        ownerRepository.deleteById(id);
        return true;
    }
}
