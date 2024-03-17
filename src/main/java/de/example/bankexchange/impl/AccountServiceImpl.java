package de.example.bankexchange.impl;

import de.example.bankexchange.entity.Account;
import de.example.bankexchange.enums.AccountStatus;
import de.example.bankexchange.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl {

    private final AccountRepository accountRepository;



    @Transactional
    public Account createAccount(Account account) {
        // Проверка наличия клиента (пропущена здесь, предполагается, что клиент существует)

        // Установка начального статуса счета
        account.setStatus(AccountStatus.ACTIVE);

        // Установка даты создания и обновления счета
        LocalDateTime now = LocalDateTime.now();
        account.setCreatedAt(now);
        account.setUpdatedAt(now);

        // Сохранение счета в репозитории
        return accountRepository.save(account);
    }

    @Transactional
    public void updateAccount(Long id, Account updatedAccount) {
        // Проверка существования счета по его идентификатору
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account existingAccount = optionalAccount.get();

            // Обновление информации о счете
            existingAccount.setBalance(updatedAccount.getBalance());
            existingAccount.setStatus(updatedAccount.getStatus());
            existingAccount.setUpdatedAt(LocalDateTime.now());

            // Сохранение обновленного счета в репозитории
            accountRepository.save(existingAccount);
        }
    }
    @Transactional
    public void deleteAccountById(Long id) {
        // Проверка существования счета по его идентификатору
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            // Удаление счета из репозитория
            accountRepository.deleteById(id);
        }
    }

    @Transactional(readOnly = true)
    public List<Account> getAllAccounts() {
        // Получение всех счетов из репозитория
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Account getAccountById(Long id) {
        // Получение счета по его идентификатору
        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.orElse(null);
    }


}