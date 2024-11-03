package com.example.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateProductRequest {

    @NotNull(message = "Product name is required")
    @NotBlank(message = "Product name is required")
    private String name;

    @Positive(message = "Product weight must be greater than 0")
    private Double weight;

}