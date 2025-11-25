package com.example.lab7.dto.car;

import com.example.lab7.dto.OwnerDto;
import lombok.Data;

@Data
public class CarFeaturesHiddenDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private double price;
    private OwnerDto owner;
}
