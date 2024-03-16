package de.example.bankexchange.impl;

import de.example.bankexchange.entity.Account;
import de.example.bankexchange.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl {

        private final AccountRepository accountRepository;

        @Autowired
        public AccountServiceImpl(AccountRepository accountRepository) {
                this.accountRepository = accountRepository;
        }

        // Метод для получения всех счетов
        public List<Account> getAllAccounts() {
                return accountRepository.findAll();
        }

        // Метод для получения информации о счете по его ID
        public Optional<Account> getAccountById(Long id) {
                return accountRepository.findById(id);
        }

        // Метод для создания нового счета
        public Account createAccount(Account account) {
                // Дополнительная бизнес-логика, если необходимо
                return accountRepository.save(account);
        }

        // Метод для обновления информации о счете
        public Optional<Account> updateAccount(Long id, Account updatedAccount) {
                // Дополнительная бизнес-логика, если необходимо
                Optional<Account> existingAccount = accountRepository.findById(id);
                if (existingAccount.isPresent()) {
                        // Обновляем информацию о счете
                        Account accountToUpdate = existingAccount.get();
                        accountToUpdate.setBalance(updatedAccount.getBalance());
                        // Другие поля для обновления

                        return Optional.of(accountRepository.save(accountToUpdate));
                } else {
                        return Optional.empty(); // Счет не найден
                }
        }

        // Метод для удаления счета по его ID
        public void deleteAccountById(Long id) {
                accountRepository.deleteById(id);
        }

        // Другие методы и бизнес-логика по необходимости
}
/*
Управление картами:

Выпуск карт: Клиент может запросить выпуск новой банковской карты. Бизнес-логика включает в
себя проверку клиентской истории, генерацию уникального номера карты и ее активацию.

Блокировка/разблокировка карты: Возможность клиента заблокировать или разблокировать свою
банковскую карту через интернет-банк или мобильное приложение. Бизнес-логика также должна учитывать
дополнительные слои безопасности.

 */