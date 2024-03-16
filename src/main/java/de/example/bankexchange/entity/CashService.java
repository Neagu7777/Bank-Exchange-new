package de.example.bankexchange.entity;

import de.example.bankexchange.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
@Getter
@Entity
@Table(name = "cash_services")
@Data
public class CashService {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    // Геттер и сеттер для поля type
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TransactionType type;

    // геттер и сеттер для amount
    @Getter
    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDateTime date;



}