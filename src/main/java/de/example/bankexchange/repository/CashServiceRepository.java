package de.example.bankexchange.repository;

import de.example.bankexchange.entity.CashService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface CashServiceRepository extends JpaRepository<CashService, Long> {

    Optional<CashService> findByAccountId(Long accountId);
}