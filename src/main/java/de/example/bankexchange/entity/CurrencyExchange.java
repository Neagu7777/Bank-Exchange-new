package de.example.bankexchange.entity;

import de.example.bankexchange.enums.CurrencyCode;
import de.example.bankexchange.enums.ExchangeRate;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Entity
@Table(name = "currency_exchanges")
@Data
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "source_currency")
    private CurrencyCode sourceCurrency;

    @Enumerated(EnumType.STRING)
    @Column(name = "target_currency")
    private CurrencyCode targetCurrency;

    @Enumerated(EnumType.STRING)
    @Column(name = "exchange_rate")
    private ExchangeRate exchangeRate;


    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date")
    private LocalDateTime date;



}