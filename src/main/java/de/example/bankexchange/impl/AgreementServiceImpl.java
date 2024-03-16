package de.example.bankexchange.impl;

import de.example.bankexchange.dto.AgreementDto;
import de.example.bankexchange.entity.Agreement;
import de.example.bankexchange.repository.AgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl {

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