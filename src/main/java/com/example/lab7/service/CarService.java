package com.example.lab7.service;

import com.example.lab7.dto.CarDto;
import com.example.lab7.entity.Car;
import com.example.lab7.mapper.CarMapper;
import com.example.lab7.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

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
        car.setId(id); // важно!

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
}
