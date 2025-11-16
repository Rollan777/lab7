package com.example.lab7.mapper;

import com.example.lab7.dto.FeatureDto;
import com.example.lab7.entity.Feature;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeatureMapper {

    FeatureDto toDto(Feature feature);

    Feature toEntity(FeatureDto dto);

    List<FeatureDto> toDtoList(List<Feature> features);
}
