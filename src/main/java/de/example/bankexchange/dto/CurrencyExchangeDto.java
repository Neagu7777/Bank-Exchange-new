package de.example.bankexchange.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CurrencyExchangeDto {
    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal exchangeRate;
    private BigDecimal amount;
    private LocalDateTime date;

    // Конструкторы, геттеры, сеттеры (автоматически генерируются Lombok'ом)


    public CurrencyExchangeDto(String sourceCurrency, String targetCurrency, BigDecimal exchangeRate, BigDecimal amount, LocalDateTime date) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
        this.amount = amount;
        this.date = date;
    }
}