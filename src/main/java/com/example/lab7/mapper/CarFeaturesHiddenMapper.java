package com.example.lab7.mapper;

import com.example.lab7.dto.car.CarFeaturesHiddenDto;
import com.example.lab7.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = OwnerMapper.class)
public interface CarFeaturesHiddenMapper {
    CarFeaturesHiddenDto toDto(Car car);
}
