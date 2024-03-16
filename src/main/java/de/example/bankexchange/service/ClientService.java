package de.example.bankexchange.service;

import de.example.bankexchange.entity.Client;
import de.example.bankexchange.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Метод для получения всех клиентов
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Метод для получения клиента по ID
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    // Метод для создания нового клиента
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Метод для удаления клиента по ID
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    // Другие методы, если необходимо
}