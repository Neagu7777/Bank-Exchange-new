package de.example.bankexchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "debit_account_id")
    private Long debitAccountId;

    @Column(name = "credit_account_id")
    private Long creditAccountId;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Transaction(Account sender, Account receiver, BigDecimal amount, String transaction) {
    }

    public Transaction(String senderBankCode, String receiverBankCode, String receiverAccountNumber, BigDecimal amount, String InterbankTransfer) {
    }

    public Transaction() {

    }
}

// Constructors, getters, setters