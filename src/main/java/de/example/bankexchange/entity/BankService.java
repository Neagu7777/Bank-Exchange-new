package de.example.bankexchange.entity;

import de.example.bankexchange.enums.BankServiceType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bank_services")
@Data
public class BankService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "service_type")
    @Enumerated(EnumType.STRING)
    private BankServiceType serviceType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Constructors, getters, setters
    //...

    public BankService() {
        // Конструктор по умолчанию
    }

    public List<BankService> getAllBankServices() {
        return null;
    }

    public BankService getBankServiceById(Long id) {

        return null;
    }

    public BankService createBankService(BankService bankService) {
        return bankService;
    }

    public void deleteBankServiceById(Long id) {
    }
    // Другие поля по необходимости

    // Конструкторы, геттеры, сеттеры
}


