package de.example.bankexchange.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cash_services")
@Data
public class CashService {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    // Геттер и сеттер для поля type
    @Getter
    @Column(name = "type")
    private String type;

    // геттер и сеттер для amount
    @Getter
    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDateTime date;


    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    // Constructors, getters, setters
    //...

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
    }

    public Long getId() {
        return null;
    }

    public void setId(Long id) {
    }

    // Дополнительные поля и связи с другими сущностями
    // Добавьте необходимые поля для реализации функционала услуги кассы

    // Конструкторы, геттеры, сеттеры
}