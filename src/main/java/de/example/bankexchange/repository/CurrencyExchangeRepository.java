package de.example.bankexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import de.example.bankexchange.entity.CurrencyExchangeEntity;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Long> {
}