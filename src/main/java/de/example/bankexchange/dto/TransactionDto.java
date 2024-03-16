package de.example.bankexchange.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TransactionDto {
    private Long id;
    private Long debitAccountId;
    private Long creditAccountId;
    private String type;
    private double amount;
    private String description;
    private LocalDateTime createdAt;

}
