package de.example.bankexchange.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ManagerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String status;
    private String description;
    private LocalDateTime createdAt;

    // Другие необходимые поля

    // Конструкторы, геттеры, сеттеры
}
