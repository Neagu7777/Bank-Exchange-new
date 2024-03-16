package de.example.bankexchange.entity;

import de.example.bankexchange.enums.AccountStatus;
import de.example.bankexchange.enums.AccountType;
import de.example.bankexchange.enums.AccountServiceType;
import de.example.bankexchange.enums.CurrencyCode;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Data
@Entity
@Table(name = "accounts")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    @Column(name = "client_id")
    private Long clientId;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private AccountServiceType name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AccountType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AccountStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_code")
    private CurrencyCode currencyCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Constructors, getters, setters




}