package com.example.lab7.dto.car;

import com.example.lab7.dto.FeatureDto;
import lombok.Data;
import java.util.List;

@Data
public class CarOwnerHiddenDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private double price;
    private List<FeatureDto> features;
}
