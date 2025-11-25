package com.example.lab7.mapper;

import com.example.lab7.dto.car.CarFullDto;
import com.example.lab7.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OwnerMapper.class, FeatureMapper.class})
public interface CarFullMapper {
    CarFullDto toDto(Car car);
}
