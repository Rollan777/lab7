package com.example.lab7.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeatureDto {

    private Long id;
    private String name;
    private String description;
}
