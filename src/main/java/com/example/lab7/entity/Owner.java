package com.example.lab7.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email; // это поле потом скроем в DTO при желании

    @OneToMany(mappedBy = "owner")
    @Builder.Default
    private List<Car> cars = new ArrayList<>();
}
