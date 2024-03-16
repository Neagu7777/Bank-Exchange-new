package de.example.bankexchange.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ProductDto {
    private Long id;
    private Long managerId;
    private String name;
    private String status;
    private String currencyCode;
    private double interestRate;
    private double limit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Другие необходимые поля

    // Конструкторы, геттеры, сеттеры
}
