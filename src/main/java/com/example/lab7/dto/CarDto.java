package com.example.lab7.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    private Long id;
    private String brand;
    private String model;
    private int year;
    private double price;

    // краткая инфа о владельце (без списка машин)
    private OwnerDto owner;

    // список фич, но без поля cars внутри
    private List<FeatureDto> features;
}
