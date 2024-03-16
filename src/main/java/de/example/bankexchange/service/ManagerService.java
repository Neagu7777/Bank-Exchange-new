package de.example.bankexchange.service;

import de.example.bankexchange.entity.Manager;
import de.example.bankexchange.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    // Метод для получения всех менеджеров
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    // Метод для получения менеджера по ID
    public Manager getManagerById(Long id) {
        return managerRepository.findById(id).orElse(null);
    }

    // Метод для создания нового менеджера
    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    // Метод для удаления менеджера по ID
    public void deleteManagerById(Long id) {
        managerRepository.deleteById(id);
    }

    // Другие методы, если необходимо
}