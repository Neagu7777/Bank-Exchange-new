package de.example.bankexchange.repository;

import de.example.bankexchange.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> { }

