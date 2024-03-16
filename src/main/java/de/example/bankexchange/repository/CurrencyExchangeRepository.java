package de.example.bankexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import de.example.bankexchange.entity.CurrencyExchange;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
}