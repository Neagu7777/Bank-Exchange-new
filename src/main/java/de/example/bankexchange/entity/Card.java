package de.example.bankexchange.entity;

import de.example.bankexchange.enums.AccountServiceType;
import de.example.bankexchange.enums.CardStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cards_service")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CardStatus status;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    public void setCreatedAt(LocalDateTime now) {
    }

    public void setUpdatedAt(LocalDateTime now) {
    }

    public char[] getName() {
        return new char[0];
    }

    public AccountServiceType getServiceType() {
        return null;
    }

    public LocalDateTime getCreatedAt() {
        return null;
    }

    public void setName(AccountServiceType accountServiceType) {
    }

    public void setServiceType(AccountServiceType serviceType) {
    }


    // Другие поля и методы
}