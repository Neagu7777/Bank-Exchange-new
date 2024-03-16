package de.example.bankexchange.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class AgreementDto {
    private Long id;
    private Long accountId;
    private Long productId;
    private double interestRate;
    private String status;
    private double sum;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Comparable<BigDecimal> getIncome() {
        return null;
    }

    public Object getAmount() {
        return null;
    }

    // Constructors, getters, setters


}
