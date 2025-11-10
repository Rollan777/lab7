package com.example.lab7.service;

import com.example.lab7.dto.CarDto;
import com.example.lab7.entity.Car;
import com.example.lab7.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;


    public CarDto toDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .price(car.getPrice())
                .build();
    }

    public Car toEntity(CarDto dto) {
        return Car.builder()
                .id(dto.getId())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .year(dto.getYear())
                .price(dto.getPrice())
                .build();
    }


    public List<CarDto> getAll() {
        return carRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public CarDto getById(Long id) {
        return carRepository.findById(id).map(this::toDto).orElse(null);
    }

    public CarDto create(CarDto dto) {
        Car car = toEntity(dto);
        return toDto(carRepository.save(car));
    }

    public CarDto update(Long id, CarDto dto) {
        Car existing = carRepository.findById(id).orElseThrow();
        existing.setBrand(dto.getBrand());
        existing.setModel(dto.getModel());
        existing.setYear(dto.getYear());
        existing.setPrice(dto.getPrice());
        return toDto(carRepository.save(existing));
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
