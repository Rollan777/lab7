package com.example.lab7.dto;

import lombok.Data;

@Data
public class ItemDto {

    private Long id;
    private String name;
    private Double price;
    private Integer quantity;

    private Long manufacturerId;
}
