package com.example.lab7.mapper;

import com.example.lab7.dto.CarDto;
import com.example.lab7.entity.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {OwnerMapper.class, FeatureMapper.class}
)
public interface CarMapper {

    CarDto toDto(Car car);

    Car toEntity(CarDto dto);

    List<CarDto> toDtoList(List<Car> cars);
}
