package de.example.bankexchange.service;

import de.example.bankexchange.dto.CurrencyExchangeDto;
import de.example.bankexchange.entity.CurrencyExchange;
import de.example.bankexchange.enums.CurrencyCode;
import de.example.bankexchange.repository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyExchangeService {
    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public List<CurrencyExchange> getAllCurrencyExchangeServices() {
        return currencyExchangeRepository.findAll();
    }

    public CurrencyExchange getCurrencyExchangeServiceById(Long id) {
        Optional<CurrencyExchange> currencyExchangeOptional = currencyExchangeRepository.findById(id);
        return currencyExchangeOptional.orElse(null);
    }

    public CurrencyExchange createCurrencyExchangeService(CurrencyExchangeDto currencyExchangeDto) {
        CurrencyExchange currencyExchange = new CurrencyExchange();
        currencyExchange.setSourceCurrency(CurrencyCode.valueOf(currencyExchangeDto.getSourceCurrency()));
        currencyExchange.setTargetCurrency(CurrencyCode.valueOf(currencyExchangeDto.getTargetCurrency()));
        currencyExchange.setSourceCurrency(CurrencyCode.valueOf(currencyExchangeDto.getSourceCurrency()));
        currencyExchange.setTargetCurrency(CurrencyCode.valueOf(currencyExchangeDto.getTargetCurrency()));
        currencyExchange.setAmount(currencyExchangeDto.getAmount());
        currencyExchange.setDate(currencyExchangeDto.getDate());
        return currencyExchangeRepository.save(currencyExchange);
    }

    public void deleteCurrencyExchangeServiceById(Long id) {
        currencyExchangeRepository.deleteById(id);
    }
}