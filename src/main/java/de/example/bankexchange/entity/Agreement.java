package de.example.bankexchange.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "agreements")
public class Agreement {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "account_id")
    private Long accountId;

    @Getter
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "interest_rate")
    private double interestRate;

    @Getter
    @Column(name = "status")
    private String status;

    @Getter
    @Column(name = "sum")
    private double sum;

    @Getter
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Getter
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public void setId(Long id) {
    }

    public void setAccountId(Long accountId) {
    }

    public void setProductId(Long productId) {
    }

    public void setInterestRate(BigDecimal interestRate) {
    }

    public void setStatus(String status) {
    }

    public void setSum(double sum) {
    }

    public void setCreatedAt(LocalDateTime createdAt) {
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
    }

    public BigDecimal getAmount(Object amount) {
        return null;
    }

    public void setAmount(Object amount) {
    }

    public BigDecimal getAmount() {
        return null;
    }


    // Constructors, getters, setters
}