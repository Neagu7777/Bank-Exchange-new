package de.example.bankexchange.repository;

import de.example.bankexchange.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> { }

