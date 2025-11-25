package com.example.lab7.service;

import com.example.lab7.dto.CarDto;
import com.example.lab7.dto.car.CarFeaturesHiddenDto;
import com.example.lab7.dto.car.CarFullDto;
import com.example.lab7.dto.car.CarOwnerHiddenDto;
import com.example.lab7.dto.car.CarShortDto;
import com.example.lab7.entity.Car;
import com.example.lab7.mapper.*;
import com.example.lab7.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final CarMapper carMapper;
    private final CarFullMapper carFullMapper;
    private final CarShortMapper carShortMapper;
    private final CarOwnerHiddenMapper carOwnerHiddenMapper;
    private final CarFeaturesHiddenMapper carFeaturesHiddenMapper;


    public List<CarDto> getAll() {
        return carMapper.toDtoList(carRepository.findAll());
    }

    public CarDto getById(Long id) {
        return carRepository.findById(id)
                .map(carMapper::toDto)
                .orElse(null);
    }

    public CarDto create(CarDto dto) {
        Car car = carMapper.toEntity(dto);
        Car saved = carRepository.save(car);
        return carMapper.toDto(saved);
    }

    public CarDto update(Long id, CarDto dto) {
        if (!carRepository.existsById(id)) {
            return null;
        }

        Car car = carMapper.toEntity(dto);
        car.setId(id);

        Car updated = carRepository.save(car);
        return carMapper.toDto(updated);
    }

    public boolean delete(Long id) {
        if (!carRepository.existsById(id)) {
            return false;
        }
        carRepository.deleteById(id);
        return true;
    }


    public CarFullDto getFull(Long id) {
        return carRepository.findById(id)
                .map(carFullMapper::toDto)
                .orElse(null);
    }

    public CarShortDto getShort(Long id) {
        return carRepository.findById(id)
                .map(carShortMapper::toDto)
                .orElse(null);
    }

    public CarOwnerHiddenDto getWithoutOwner(Long id) {
        return carRepository.findById(id)
                .map(carOwnerHiddenMapper::toDto)
                .orElse(null);
    }

    public CarFeaturesHiddenDto getWithoutFeatures(Long id) {
        return carRepository.findById(id)
                .map(carFeaturesHiddenMapper::toDto)
                .orElse(null);
    }
}
