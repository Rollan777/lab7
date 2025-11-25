package com.example.lab7.mapper;

import com.example.lab7.dto.ItemDto;
import com.example.lab7.entity.Country;
import com.example.lab7.entity.Item;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "manufacturerId", source = "manufacturer.id")
    ItemDto toDto(Item item);

    @Mapping(target = "manufacturer", source = "manufacturerId", qualifiedByName = "mapManufacturer")
    Item toEntity(ItemDto dto);

    List<ItemDto> toDtoList(List<Item> list);


    @Named("mapManufacturer")
    default Country mapManufacturer(Long id) {
        if (id == null) return null;
        Country c = new Country();
        c.setId(id);
        return c;
    }
}
