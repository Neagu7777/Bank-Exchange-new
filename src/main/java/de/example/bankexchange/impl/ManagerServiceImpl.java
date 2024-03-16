package de.example.bankexchange.impl;

import de.example.bankexchange.entity.Manager;
import de.example.bankexchange.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl {
    @Autowired
    private final ManagerRepository managerRepository;

    public List<Manager> getAllManagers() {
        // Вернуть список всех менеджеров
        return managerRepository.findAll();
    }

    public Optional<Manager> getManagerById(Long id) {
        // Вернуть менеджера по ID, если существует
        return managerRepository.findById(id);
    }

    public Manager createManager(Manager manager) {
        // Создать нового менеджера
        return managerRepository.save(manager);
    }

    public void deleteManagerById(Long id) {
        // Удалить менеджера по ID
        managerRepository.deleteById(id);
    }

    // Дополнительные методы и бизнес-логика по необходимости
}