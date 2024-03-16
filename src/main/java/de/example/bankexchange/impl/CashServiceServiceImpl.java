package de.example.bankexchange.impl;

import de.example.bankexchange.entity.CashService;
import de.example.bankexchange.repository.CashServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CashServiceServiceImpl {

    @Autowired
    private CashServiceRepository cashServiceRepository;

    // Другие методы, если необходимо

    // Внесение наличных
    public boolean depositCash(Long accountId, double amount) {
        Optional<CashService> cashService = cashServiceRepository.findByAccountId(accountId);

        if (cashService.isPresent()) {
            CashService cashServiceEntity = cashService.get();
            cashServiceEntity.setAmount(cashServiceEntity.getAmount().add(BigDecimal.valueOf(amount)));
            cashServiceRepository.save(cashServiceEntity);
            return true; // Успешное внесение наличных
        } else {
            // Создаем новую сущность, если счет не найден
            CashService cashServiceEntity = new CashService();
            cashServiceEntity.setAccountId(accountId);
            cashServiceEntity.setAmount(BigDecimal.valueOf(amount));
            cashServiceRepository.save(cashServiceEntity);
            return true; // Успешное внесение наличных
        }
    }

    // Снятие наличных
    public boolean withdrawCash(Long accountId, double amount) {
        Optional<CashService> cashService = cashServiceRepository.findByAccountId(accountId);

        if (cashService.isPresent()) {
            CashService cashServiceEntity = cashService.get();

            // Проверяем, достаточно ли средств на счете
            if (cashServiceEntity.getAmount().doubleValue() >= amount) {
                cashServiceEntity.setAmount(cashServiceEntity.getAmount().subtract(BigDecimal.valueOf(amount)));
                cashServiceRepository.save(cashServiceEntity);
                return true; // Успешное снятие наличных
            } else {
                return false; // Недостаточно средств на счете
            }
        } else {
            return false; // Счет не найден
        }
    }
}
    /*

Внесение наличных: Пользователь может внести определенную сумму наличных средств на
свой банковский счет через кассу. Бизнес-логика должна включать проверку валидности банкнот,
обновление баланса счета и ведение журнала операций.

Снятие наличных: Клиент может запросить снятие наличных с использованием кассы.
Бизнес-логика должна учитывать наличие достаточных средств на счете, проверку лимитов снятия и
обновление баланса.

1. услуги кассы:

внесение наличных:

Проверяем, достаточно ли средств на счете
Вызов метода для внесения наличных с определенной суммой.
баланс счета пользователя увеличился на соответствующую сумму.

снятие наличных:


Установка начального баланса счета пользователя.
Вызов метода для снятия наличных с определенной суммой.
Проверка, что баланс счета уменьшился соответственно, при наличии достаточных средств.

 */
