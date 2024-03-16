package de.example.bankexchange.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AccountDto {
    private Long id;
    private Long clientId;
    private String name;
    private String type;
    private String status;
    private double balance;
    private String currencyCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors, getters, setters
    // Другие поля, если необходимо

    // Конструкторы, геттеры, сеттеры

}
