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
