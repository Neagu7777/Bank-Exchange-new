package de.example.bankexchange.service;

import de.example.bankexchange.entity.Account;
import de.example.bankexchange.enums.AccountStatus;
import de.example.bankexchange.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.orElse(null);
    }


        @Transactional
        public Account createAccount(Account account) {
            // Assuming you have proper validation and default values setting here
            account.setStatus(AccountStatus.ACTIVE);
            account.setCreatedAt(LocalDateTime.now());
            account.setUpdatedAt(LocalDateTime.now());

            // Saving the account in the repository
            return accountRepository.save(account);
        }

        // Other methods of the service


    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    public Account updateAccount(Long id, Account updatedAccount) {
        return updatedAccount;
    }

    // Additional methods can be added here
}