package de.example.bankexchange.entity;

import de.example.bankexchange.enums.AccountStatus;
import de.example.bankexchange.enums.ProductAgreement;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@Data
@Entity
@Table(name = "agreements")
public class Agreement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @Enumerated(EnumType.STRING)
    @Column(name = "product_id")
    private ProductAgreement productId;


    @Column(name = "interest_rate")
    private String interestRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AccountStatus status;


    @Column(name = "sum")
    private double sum;


    @Column(name = "created_at")
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



}