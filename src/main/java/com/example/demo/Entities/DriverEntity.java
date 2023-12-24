package com.example.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Entity(name = "driver")
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_id_generator")
    @SequenceGenerator(name = "driver_id_generator", sequenceName = "driver_id_seq", allocationSize = 50)
    private Long id;

    @Size(max = 50, min = 1, message = "DRIVER NAME: must be between 1 and 50 characters")
    @Column(nullable = false)
    private String name;

    @Max(value = 70, message = "DRIVER AGE: must be less or equals than 70 years old")
    @Min(value = 18, message = "DRIVER AGE: must be more or equals that 18 years old")
    @Column(nullable = false)
    private Integer age;

}
