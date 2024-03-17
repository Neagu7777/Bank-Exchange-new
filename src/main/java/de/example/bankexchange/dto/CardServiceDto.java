package de.example.bankexchange.dto;

import de.example.bankexchange.enums.AccountServiceType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CardServiceDto {

    private Long id;
    private String name;
    private AccountServiceType serviceType;
    private LocalDateTime createdAt;

    // Constructors, getters, setters
}