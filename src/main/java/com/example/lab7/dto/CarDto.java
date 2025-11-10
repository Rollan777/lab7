package com.example.lab7.dto;

import lombok.*;

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
}
