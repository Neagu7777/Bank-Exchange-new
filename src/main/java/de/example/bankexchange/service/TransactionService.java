package de.example.bankexchange.service;

import de.example.bankexchange.entity.Transaction;
import de.example.bankexchange.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Метод для получения всех транзакций
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Метод для получения транзакции по ID
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    // Метод для создания новой транзакции
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Метод для удаления транзакции по ID
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }

    // Другие методы, если необходимо
}