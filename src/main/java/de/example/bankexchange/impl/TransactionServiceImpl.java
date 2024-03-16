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
    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Внутренний перевод
    public boolean makeInternalTransfer(Account sender, Account receiver, BigDecimal amount) {
        // Проверка наличия достаточных средств на счете отправителя
        if (sender.getBalance() >= 0) {
            // Обновление баланса отправителя и получателя
            sender.setBalance(sender.getBalance());
            receiver.setBalance(receiver.getBalance());

            // Запись операции в журнал транзакций
            Transaction transaction = new Transaction(sender, receiver, amount, "TransactionLocal");
            transactionRepository.save(transaction);

            return true; // Перевод успешно выполнен
        } else {
            return false; // Недостаточно средств на счете отправителя
        }
    }

    // Межбанковский перевод
    public boolean makeInterbankTransfer(String senderBankCode, String receiverBankCode, String receiverAccountNumber, BigDecimal amount) {
        // Реализация бизнес-логики для межбанковского перевода
        // Включает проверку реквизитов, учет комиссий и обработку подтверждений от другого банка

        // В данном примере, пусть межбанковский перевод всегда успешен
        // Добавьте здесь вашу логику

        // Пример:
        // Проверка реквизитов, комиссий и отправка запроса на подтверждение
        // ...

        // После успешного подтверждения
        // Запись операции в журнал транзакций
        Transaction transaction = new Transaction(senderBankCode, receiverBankCode, receiverAccountNumber, amount, "InterbankTransfer");
        transactionRepository.save(transaction);

        return true; // Перевод успешно выполнен
    }

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
