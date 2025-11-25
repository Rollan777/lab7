package com.example.lab7.mapper;

import com.example.lab7.dto.car.CarOwnerHiddenDto;
import com.example.lab7.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = FeatureMapper.class)
public interface CarOwnerHiddenMapper {
    CarOwnerHiddenDto toDto(Car car);
}
