package de.example.bankexchange.entity;

import de.example.bankexchange.enums.AccountServiceType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "bank_services")
@Data
public class BankService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private AccountServiceType name;

    @Column(name = "service_type")
    @Enumerated(EnumType.STRING)
    private AccountServiceType serviceType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Constructors, getters, setters
    //...


    // Конструкторы, геттеры, сеттеры
}


