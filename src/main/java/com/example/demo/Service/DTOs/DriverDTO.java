package com.example.demo.Service.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
    @NotBlank(message = "Driver name mustn't be blank")
    private String name;
    @NotBlank(message = "Driver age mustn't be blank")
    private int age;
}
