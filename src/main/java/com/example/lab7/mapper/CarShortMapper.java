package com.example.lab7.mapper;

import com.example.lab7.dto.car.CarShortDto;
import com.example.lab7.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarShortMapper {
    CarShortDto toDto(Car car);
}
