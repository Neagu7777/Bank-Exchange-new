package de.example.bankexchange.service;

import de.example.bankexchange.dto.CurrencyExchangeDto;
import de.example.bankexchange.entity.CurrencyExchangeEntity;
import de.example.bankexchange.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public List<CurrencyExchangeEntity> getAllCurrencyExchangeServices() {
        return currencyExchangeRepository.findAll();
    }

    public CurrencyExchangeEntity getCurrencyExchangeServiceById(Long id) {
        Optional<CurrencyExchangeEntity> optionalService = currencyExchangeRepository.findById(id);
        return optionalService.orElse(null);
    }

    public CurrencyExchangeEntity createCurrencyExchangeService(CurrencyExchangeDto currencyExchangeDto) {
        CurrencyExchangeEntity entity = mapDtoToEntity(currencyExchangeDto);
        return currencyExchangeRepository.save(entity);
    }

    public void deleteCurrencyExchangeServiceById(Long id) {
        currencyExchangeRepository.deleteById(id);
    }

    private CurrencyExchangeEntity mapDtoToEntity(CurrencyExchangeDto dto) {
        CurrencyExchangeEntity entity = new CurrencyExchangeEntity();
        entity.setSourceCurrency(dto.getSourceCurrency());
        entity.setTargetCurrency(dto.getTargetCurrency());
        entity.setExchangeRate(dto.getExchangeRate());
        entity.setAmount(dto.getAmount());
        entity.setDate(dto.getDate());
        // Заполните другие поля, если есть
        return entity;
    }

    // Другие методы, если необходимо
}