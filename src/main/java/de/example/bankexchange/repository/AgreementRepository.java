package de.example.bankexchange.repository;

import de.example.bankexchange.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Long> { }

