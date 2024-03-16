package de.example.bankexchange.dto;

import de.example.bankexchange.enums.BankServiceType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BankServiceDto {

    private Long id;
    private String name;
    private BankServiceType serviceType;
    private LocalDateTime createdAt;

    // Constructors, getters, setters
}