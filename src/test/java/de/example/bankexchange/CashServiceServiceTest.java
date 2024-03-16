package de.example.bankexchange;

import de.example.bankexchange.dto.CashServiceDto;
import de.example.bankexchange.entity.CashService;
import de.example.bankexchange.repository.CashServiceRepository;
import de.example.bankexchange.service.CashServiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CashServiceServiceTest {

    @Mock
    private CashServiceRepository cashServiceRepository;

    @InjectMocks
    private CashServiceService cashServiceService;
    private Object cashRepository;

    @Test
    public void testCreateCashService() {
        // Создаем объект CashServiceDto для передачи в метод
        CashServiceDto cashServiceDto = new CashServiceDto(/*...*/);

        // Создаем объект CashService для возвращения при вызове метода save
        CashService cashService = new CashService(/*...*/);

        // Указываем поведение мок-репозитория
        when(cashServiceRepository.save(any())).thenReturn(cashService);

        // Вызываем метод сервиса
        CashServiceDto result = cashServiceService.createCashService(cashServiceDto);

        // Проверяем, что результат не является null и соответствует преобразованному мок-репозиторию
        assertNotNull(result);
        assertEquals(cashService.getId(), result.getId());
        // Дополнительные проверки при необходимости
    }




    @Test
    public void testDepositCash() {
        // Создаем фиктивный объект кассы
        CashService cashService = new CashService();
        cashService.setAccountId(123L);
        cashService.setAmount(BigDecimal.valueOf(1000));

        // Устанавливаем ожидаемое значение при вызове метода findByAccountId
        when(cashServiceRepository.findByAccountId(123L)).thenReturn(Optional.of(cashService));

        // Вызываем метод для внесения наличных
        CashServiceDto result = cashServiceService.depositCash(123L, 1500);

        // Проверяем, что баланс счета пользователя увеличился на 1500
        assertEquals(BigDecimal.valueOf(2500.0), result.getAmount());
    }

    @Test
    public void testWithdrawCashWithSufficientFunds() {
        // Создаем фиктивный объект кассы
        CashService cashService = new CashService();
        cashService.setAccountId(456L);
        cashService.setAmount(BigDecimal.valueOf(100));

        // Устанавливаем ожидаемое значение при вызове метода findByAccountId
        when(cashServiceRepository.findByAccountId(456L)).thenReturn(Optional.of(cashService));

        // Вызываем метод для снятия наличных
        CashServiceDto result = cashServiceService.withdrawCash(456L, 50);

        // Проверка результата, чтобы не было NullPointerException

        // Проверяем, что баланс счета пользователя уменьшился на 50
        assertEquals(BigDecimal.valueOf(50), result.getAmount());  // Изменение здесь
    }
//    @Test
//    public void testWithdrawCashWithSufficientFunds() {
//        // Создаем фиктивный объект кассы
//        CashService cashService = new CashService();
//        cashService.setAccountId(456L);
//        cashService.setAmount(BigDecimal.valueOf(100));
//
//        // Устанавливаем ожидаемое значение при вызове метода findByAccountId
//        when(cashServiceRepository.findByAccountId(456L)).thenReturn(Optional.of(cashService));
//
//        // Вызываем метод для снятия наличных
//        CashServiceDto result = cashServiceService.withdrawCash(456L, 50);
//        // Проверка результата, чтобы не было NullPointerException
//        assertNotNull(result);
//        // Проверяем, что баланс счета пользователя уменьшился на 50
//        assertEquals(BigDecimal.valueOf(50), result.getAmount());
//    }

//    @Test
//    public void testWithdrawCashWithSufficientFunds() {
//        // Подготовка данных
//        CashServiceDto request = new CashServiceDto();
//        request.setAmount(BigDecimal.valueOf(1000.0));
//
//        // Убедитесь, что вы правильно настроили mock-объект
//        when(cashRepository.findCashByAccountId(1L)).thenReturn(new Cash(1L, 2000.0));
//
//        // Выполнение операции
//        CashServiceDto result = cashServiceService.withdrawCash(request);
//
//        // Проверка результата, чтобы не было NullPointerException
//        assertNotNull(result);
//
//        // Проверка, что у объекта result есть значение
//        assertNotNull(result.getAmount());
//
//        // Теперь вы можете продолжить с вашими ожиданиями и утверждениями
//        assertEquals(1000.0, result.getAmount(), 0.01);
//    }

    @Test
    public void testWithdrawCashWithInsufficientFunds() {
        // Создаем фиктивный объект кассы с недостаточными средствами
        CashService cashService = new CashService();
        cashService.setAccountId(789L);
        cashService.setAmount(BigDecimal.valueOf(30));

        // Устанавливаем ожидаемое значение при вызове метода findByAccountId
        when(cashServiceRepository.findByAccountId(789L)).thenReturn(Optional.of(cashService));

        // Вызываем метод для снятия наличных
        assertThrows(RuntimeException.class, () -> cashServiceService.withdrawCash(789L, 50));
    }
}
/*
1. Тесты для услуги кассы:

Тест на внесение наличных:

Создание фиктивного объекта кассы.
Вызов метода для внесения наличных с определенной суммой.
Проверка, что баланс счета пользователя увеличился на соответствующую сумму.

Тест на снятие наличных:

Создание фиктивного объекта кассы.
Установка начального баланса счета пользователя.
Вызов метода для снятия наличных с определенной суммой.
Проверка, что баланс счета уменьшился соответственно, при наличии достаточных средств.

 */