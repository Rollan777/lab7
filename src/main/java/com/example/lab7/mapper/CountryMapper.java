package com.example.lab7.mapper;

import com.example.lab7.dto.CountryDto;
import com.example.lab7.entity.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDto toDto(Country country);

    Country toEntity(CountryDto dto);

    List<CountryDto> toDtoList(List<Country> list);
}
