package de.example.bankexchange.entity;

import de.example.bankexchange.enums.AccountServiceType;
import de.example.bankexchange.enums.CardStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "cards_service")
@Data
public class Card {
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

    public void setAccount(Account account) {
    }

    public void setCardNumber(String s) {
    }

    public void setStatus(CardStatus cardStatus) {
    }

    public void setUpdatedAt(LocalDateTime now) {
    }

    public org.junit.platform.engine.TestEngine getAccount() {
        return null;
    }

    public CardStatus getStatus() {
        return null;
    }

    // Constructors, getters, setters
    //...


    // Конструкторы, геттеры, сеттеры
}


