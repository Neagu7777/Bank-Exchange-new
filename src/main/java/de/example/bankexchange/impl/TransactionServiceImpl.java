package de.example.bankexchange.impl;

import de.example.bankexchange.entity.Account;
import de.example.bankexchange.entity.Transaction;
import de.example.bankexchange.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl {

}
/*
Услуги переводов:

Внутренние переводы: Клиент может запросить перевод средств между своими счетами или
на счет другого клиента внутри банка. Бизнес-логика должна включать проверку наличия достаточных средств,
обновление баланса отправителя и получателя, а также запись операции в журнал.

Межбанковские переводы: Возможность перевода средств между банками. Бизнес-логика должна включать
проверку правильности реквизитов, учет комиссий за межбанковский перевод и обработку подтверждений от
другого банка.

 */
/*
Управление уведомлениями:

Уведомления о транзакциях: Клиент может настроить уведомления о каждой транзакции на своем счете.
Бизнес-логика включает в себя отслеживание транзакций, отправку уведомлений и учет предпочтений клиента.

Уведомления о просроченных платежах: В случае просрочки по кредиту или задолженности, система может
автоматически отправлять уведомления клиенту с информацией о задолженности и штрафах.

 */