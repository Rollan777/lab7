package com.example.lab7.dto.car;

import com.example.lab7.dto.FeatureDto;
import com.example.lab7.dto.OwnerDto;
import lombok.Data;
import java.util.List;

@Data
public class CarFullDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private double price;
    private OwnerDto owner;
    private List<FeatureDto> features;
}
