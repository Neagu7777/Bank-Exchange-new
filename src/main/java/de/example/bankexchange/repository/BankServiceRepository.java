package de.example.bankexchange.repository;

import de.example.bankexchange.entity.BankService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BankServiceRepository extends JpaRepository<BankService, Long> { }


