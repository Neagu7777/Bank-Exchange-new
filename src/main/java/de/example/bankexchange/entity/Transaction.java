package de.example.bankexchange.entity;

import de.example.bankexchange.enums.ProductAgreement;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@Data
@Entity
@Table(name = "transactions_servise")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "debit_account_id")
    private Long debitAccountId;

    @Column(name = "credit_account_id")
    private Long creditAccountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AccessType type;

    @Column(name = "amount")
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "description")
    private ProductAgreement description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


}

// Constructors, getters, setters