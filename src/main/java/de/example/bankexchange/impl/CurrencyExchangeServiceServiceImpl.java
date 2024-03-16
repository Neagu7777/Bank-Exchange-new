package de.example.bankexchange.impl;

import de.example.bankexchange.dto.CurrencyExchangeDto;
import de.example.bankexchange.entity.CurrencyExchange;
import de.example.bankexchange.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeServiceServiceImpl {


}
/*
Услуги обмена валют:

Курсы обмена: Система должна отслеживать текущие курсы валют и предоставлять клиенту актуальную информацию перед
обменом валюты. Бизнес-логика также должна включать расчет суммы после обмена, включая комиссии.

Обмен валюты: Пользователь может запросить обмен одной валюты на другую. Бизнес-логика должна учитывать
текущий курс, проверку наличия необходимой суммы валюты для обмена и обновление баланса счетов клиента.

В каждом из этих примеров важно учесть аспекты безопасности, логирование операций, управление транзакциями и
взаимодействие с базой данных для хранения информации о клиентах, операциях и других необходимых данных.

 */