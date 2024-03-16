package de.example.bankexchange.service;

import de.example.bankexchange.entity.Account;
import de.example.bankexchange.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Метод для получения всех аккаунтов
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Метод для получения аккаунта по ID
    public Account getAccountById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.orElse(null);
        // Возвращаем аккаунт по id или null, если не найден
    }

    // Метод для создания нового аккаунта
    public Account createAccount(Account account) {
        // Допустим, что у вас есть метод save в репозитории, который сохраняет сущность в базе данных
        return accountRepository.save(account);
        // Возвращаем созданный аккаунт
    }

    // Метод для удаления аккаунта по ID
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
        // Удаляем аккаунт по id
    }

    // Метод для обновления данных аккаунта
    public Account updateAccount(Long id, Account updatedAccount) {
        Optional<Account> existingAccount = accountRepository.findById(id);

        if (existingAccount.isPresent()) {
            // Обновляем поля аккаунта на основе данных из updatedAccount
            Account account = existingAccount.get();
            account.setName(updatedAccount.getName());
            account.setType(updatedAccount.getType());
            account.setStatus(updatedAccount.getStatus());
            account.setBalance(updatedAccount.getBalance());
            account.setCurrencyCode(updatedAccount.getCurrencyCode());
            // Обновите остальные поля при необходимости

            // Сохраняем обновленный аккаунт в репозитории
            return accountRepository.save(account);
        } else {
            return null; // Или выбросите исключение, в зависимости от ваших требований
        }
    }
}