package de.example.bankexchange.impl;

import de.example.bankexchange.entity.Client;
import de.example.bankexchange.repository.ClientRepository;
import de.example.bankexchange.service.BankServiceService;
import de.example.bankexchange.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl {

    @Autowired
    private final ClientRepository clientRepository;

    public Optional<Client> getClientById(Long id) {
        // Вернуть клиента по ID, если существует
        return clientRepository.findById(id);
    }

    public Client createClient(Client client) {
        // Создать нового клиента
        return clientRepository.save(client);
    }

    public void deleteClientById(Long id) {
        // Удалить клиента по ID
        clientRepository.deleteById(id);
    }

    // Дополнительные методы и бизнес-логика по необходимости
}


