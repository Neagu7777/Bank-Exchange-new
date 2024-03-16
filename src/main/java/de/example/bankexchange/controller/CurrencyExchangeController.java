package de.example.bankexchange.controller;


import de.example.bankexchange.dto.CurrencyExchangeDto;
import de.example.bankexchange.entity.CurrencyExchange;
import de.example.bankexchange.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/currency-exchange-services")
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("all")
    public ResponseEntity<List<CurrencyExchange>> getAllCurrencyExchangeServices() {
        List<CurrencyExchange> currencyExchangeServices = currencyExchangeService.getAllCurrencyExchangeServices();
        return new ResponseEntity<>(currencyExchangeServices, HttpStatus.OK);
    }

    @GetMapping("info/{id}")
    public ResponseEntity<CurrencyExchange> getCurrencyExchangeServiceById(@PathVariable Long id) {
        CurrencyExchange currencyExchangeService = this.currencyExchangeService.getCurrencyExchangeServiceById(id);
        return (currencyExchangeService != null) ? new ResponseEntity<>(currencyExchangeService, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("post/{id}")
    public ResponseEntity<CurrencyExchange> createCurrencyExchangeService(@RequestBody CurrencyExchangeDto currencyExchangeDto) {
        CurrencyExchange currencyExchangeService = this.currencyExchangeService.createCurrencyExchangeService(currencyExchangeDto);
        return new ResponseEntity<>(currencyExchangeService, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCurrencyExchangeServiceById(@PathVariable Long id) {
        this.currencyExchangeService.deleteCurrencyExchangeServiceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}