package com.example.lab7.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeatureDto {

    private Long id;
    private String name;
    // description можно скрыть, если нужно "чистый" ответ
    private String description;
}
