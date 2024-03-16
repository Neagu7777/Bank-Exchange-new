package de.example.bankexchange.service;

import de.example.bankexchange.entity.Manager;
import de.example.bankexchange.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Manager getManagerById(Long id) {
        Optional<Manager> managerOptional = managerRepository.findById(id);
        return managerOptional.orElse(null);
    }

    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public void deleteManagerById(Long id) {
        managerRepository.deleteById(id);
    }
}