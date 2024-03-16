package de.example.bankexchange.impl;

import de.example.bankexchange.dto.CurrencyExchangeDto;
import de.example.bankexchange.entity.CurrencyExchangeEntity;
import de.example.bankexchange.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CurrencyExchangeServiceServiceImpl {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CurrencyExchangeServiceServiceImpl(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    // Другие методы, если необходимо

    // Хранение текущих курсов обмена
    private final Map<String, Double> exchangeRates = new HashMap<>();

    // Хранение балансов пользователей по валютам
    private final Map<String, Map<String, Double>> userBalances = new HashMap<>();

    // Установка текущих курсов обмена
    public void setExchangeRates(String sourceCurrency, String targetCurrency, double rate) {
        exchangeRates.put(sourceCurrency + targetCurrency, rate);
    }

    // Получение текущего курса обмена
    public double getExchangeRate(String sourceCurrency, String targetCurrency) {
        return exchangeRates.getOrDefault(sourceCurrency + targetCurrency, 0.0);
    }

    // Установка баланса счета пользователя
    public void setAccountBalance(String userId, String currency, double balance) {
        userBalances.computeIfAbsent(userId, k -> new HashMap<>()).put(currency, balance);
    }

    // Метод для обмена валюты
    @Transactional
    public CurrencyExchangeEntity exchangeCurrency(String userId, CurrencyExchangeDto exchangeDto) {
        // Получаем информацию о валютах и сумме обмена
        String sourceCurrency = exchangeDto.getSourceCurrency();
        String targetCurrency = exchangeDto.getTargetCurrency();
        BigDecimal amount = exchangeDto.getAmount();

        // Получаем текущий курс обмена и баланс счета пользователя
        double exchangeRate = getExchangeRate(sourceCurrency, targetCurrency);
        double sourceBalance = userBalances.getOrDefault(userId, new HashMap<>()).getOrDefault(sourceCurrency, 0.0);

        // Вычисляем обмененную сумму и обновляем балансы
        BigDecimal exchangedAmount = amount.multiply(BigDecimal.valueOf(exchangeRate));
        BigDecimal newSourceBalance = BigDecimal.valueOf(sourceBalance).subtract(amount);
        BigDecimal newTargetBalance = BigDecimal.valueOf(userBalances.computeIfAbsent(userId, k -> new HashMap<>())
                .getOrDefault(targetCurrency, 0.0)).add(exchangedAmount);

        // Обновляем балансы пользователя
        userBalances.get(userId).put(sourceCurrency, newSourceBalance.doubleValue());
        userBalances.get(userId).put(targetCurrency, newTargetBalance.doubleValue());

        // Создаем объект для хранения информации об обмене
        CurrencyExchangeEntity entity = new CurrencyExchangeEntity(userId, sourceCurrency, targetCurrency,
                amount, exchangedAmount, newTargetBalance);

        // Сохраняем данные в репозитории
        currencyExchangeRepository.save(entity);

        return entity;
    }

    // Добавлен метод для обновления текущих курсов валют в репозитории
    @Transactional
    public void updateExchangeRatesInRepository() {
        for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
            String sourceCurrency = entry.getKey().substring(0, 3);
            String targetCurrency = entry.getKey().substring(3);
            BigDecimal exchangeRate = BigDecimal.valueOf(entry.getValue());

            CurrencyExchangeEntity entity = new CurrencyExchangeEntity(null, sourceCurrency, targetCurrency,
                    BigDecimal.ZERO, BigDecimal.ZERO, exchangeRate);

            // Сохраняем данные в репозитории
            currencyExchangeRepository.save(entity);
        }
    }
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