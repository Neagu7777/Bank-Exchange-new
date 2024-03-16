package de.example.bankexchange.impl;

import de.example.bankexchange.dto.AgreementDto;
import de.example.bankexchange.entity.Agreement;
import de.example.bankexchange.repository.AgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl {

    private final AgreementRepository agreementRepository;

    // Метод для оценки кредитоспособности
    public boolean assessCreditworthiness(AgreementDto agreementDto) {
        // Здесь должна быть бизнес-логика оценки кредитоспособности
        // Можете использовать информацию из agreementDto, например, кредитную историю и доходы

        // Пример: Пусть положительный результат оценки будет, если доход больше 5000
        return agreementDto.getIncome().compareTo(BigDecimal.valueOf(5000)) > 0;
    }

    // Метод для выдачи займа
    public Optional<Agreement> issueAgreement(AgreementDto agreementDto) {
        // Перед выдачей займа можно снова проверить кредитоспособность
        if (assessCreditworthiness(agreementDto)) {
            Agreement agreement = new Agreement();
            agreement.setAmount(agreementDto.getAmount());
            agreement.setInterestRate(BigDecimal.valueOf(0.05)); // Пример установки ставки 5%

            // Здесь может быть логика учета процентов, автоматического списания и т.д.

            // Сохраняем займ в репозитории
            return Optional.of(agreementRepository.save(agreement));
        } else {
            // Кредитоспособность не соответствует требованиям
            return Optional.empty();
        }
    }

    // Метод для расчета процентов по займу
    public BigDecimal calculateInterest(Agreement agreement) {
        // Здесь бизнес-логика для расчета процентов по займу
        // Пример: Сумма займа * ставка
        return agreement.getAmount().multiply(BigDecimal.valueOf(agreement.getInterestRate()));
    }
}
/*
Услуги выдачи займов:

Оценка кредитоспособности: Перед выдачей займа система должна оценить кредитоспособность заявителя.
Это включает в себя проверку кредитной истории, доходов и других критериев. В случае положительного решения,
выдача займа.

Расчет процентов: Система должна автоматически рассчитывать сумму процентов по выданному займу на
основе установленных ставок. Бизнес-логика также может включать в себя автоматическое списание процентов
по графику платежей.


 */