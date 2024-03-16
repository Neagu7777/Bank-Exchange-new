package de.example.bankexchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "currency_exchanges")
@Data
public class CurrencyExchangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_currency")
    private String sourceCurrency;

    @Column(name = "target_currency")
    private String targetCurrency;

    @Column(name = "exchange_rate")
    private BigDecimal exchangeRate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date")
    private LocalDateTime date;



    public CurrencyExchangeEntity(String userId, String sourceCurrency, String targetCurrency, BigDecimal amount, double exchangedAmount, double newTargetBalance) {

    }



    public CurrencyExchangeEntity(String userId, String sourceCurrency, String targetCurrency, BigDecimal amount, BigDecimal bigDecimal, BigDecimal bigDecimal1) {

    }

    public CurrencyExchangeEntity() {

    }

    // Constructors, getters, setters (автоматически генерируются Lombok'ом)

    // Дополнительные поля и связи с другими сущностями
    // Добавьте необходимые поля для реализации функционала обмена валюты

    // Конструкторы, геттеры, сеттеры
}