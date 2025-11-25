package com.example.lab7.dto.car;

import lombok.Data;

@Data
public class CarShortDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private double price;
}
