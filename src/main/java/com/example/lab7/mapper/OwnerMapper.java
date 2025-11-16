package com.example.lab7.mapper;

import com.example.lab7.dto.OwnerDto;
import com.example.lab7.entity.Owner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerDto toDto(Owner owner);

    Owner toEntity(OwnerDto dto);

    List<OwnerDto> toDtoList(List<Owner> owners);
}
