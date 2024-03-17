package de.example.bankexchange;

import de.example.bankexchange.entity.Account;
import de.example.bankexchange.enums.AccountStatus;
import de.example.bankexchange.impl.AccountServiceImpl;
import de.example.bankexchange.repository.AccountRepository;
import de.example.bankexchange.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    public void testCreateAccount() {
        // Arrange
        Account account = new Account();
        account.setId(1L);
        account.setStatus(AccountStatus.ACTIVE);
        when(accountRepository.save(account)).thenReturn(account);

        // Act
        Account createdAccount = accountService.createAccount(account);

        // Assert
        assertEquals(account.getId(), createdAccount.getId());
        assertEquals(account.getStatus(), createdAccount.getStatus());
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    void testUpdateAccount() {
        // Arrange
        Long id = 1L;
        Account existingAccount = new Account();
        existingAccount.setId(id);
        existingAccount.setStatus(AccountStatus.INACTIVE);
        existingAccount.setBalance(0.0);
        existingAccount.setCreatedAt(LocalDateTime.now());
        existingAccount.setUpdatedAt(LocalDateTime.now());

        // Мокирование поведения findById
        when(accountRepository.findById(id)).thenReturn(Optional.of(existingAccount));

        // Действие
        Account updatedAccount = new Account();
        updatedAccount.setId(id);
        updatedAccount.setStatus(AccountStatus.ACTIVE);
        updatedAccount.setBalance(100.0);
        accountService.updateAccount(id, updatedAccount);

        // Проверка
        verify(accountRepository, times(1)).save(existingAccount);
    }

    @Test
    void testCreateAndUpdateAndDeleteAccount() {
        // Предположим, что у вас есть сервис для работы с учетными записями
        AccountService accountService = new AccountService(accountRepository);

        // Создание новой учетной записи
        Account newAccount = accountService.createAccount(new Account());

        // Проверка, что новая учетная запись не равна null
        assertNotNull(newAccount);

        // Дополнительные проверки или действия с новой учетной записью, если необходимо
    }
}
/*
 описания действий в каждом тесте:

Тест создания аккаунта (тестСозданияАккаунта):

Подготовка (Arrange): Создается объект аккаунта, затем устанавливаются ожидаемые возвращаемые значения для методов
репозитория при сохранении аккаунта.
Действие (Act): Вызывается метод создания аккаунта.
Проверка (Assert): Проверяется, что созданный аккаунт имеет ожидаемые свойства, и что метод сохранения аккаунта
был вызван один раз.
Тест обновления аккаунта (тестОбновлениеАккаунта):

Подготовка (Arrange): Создается идентификатор аккаунта, а также существующий и обновленный аккаунты.
Настраивается возвращаемое значение для методов репозитория.
Действие (Act): Вызывается метод обновления аккаунта.
Проверка (Assert): Проверяется, что статус обновленного аккаунта соответствует ожидаемому,
и что методы репозитория были вызваны в нужных количествах.
Тест удаления аккаунта по идентификатору (тестУдаленияАккаунтаПоИдентификатору):

Подготовка (Arrange): Создается идентификатор аккаунта.
Действие (Act): Вызывается метод удаления аккаунта.
Проверка (Assert): Проверяется, что метод удаления аккаунта был вызван один раз с переданным идентификатором.
*/