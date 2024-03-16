package de.example.bankexchange.controller;

import de.example.bankexchange.dto.BankServiceDto;
import de.example.bankexchange.entity.Account;
import de.example.bankexchange.service.BankServiceService;
import de.example.bankexchange.service.BankServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bank-services")
public class BankServiceController {

    private final BankServiceService bankServiceService;

    @GetMapping("all")
    public ResponseEntity<List<BankServiceDto>> getAllBankServices() {
        List<BankServiceDto> bankServices = bankServiceService.getAllBankServices();
        return new ResponseEntity<>(bankServices, HttpStatus.OK);
    }

    @GetMapping("info/{id}")
    public ResponseEntity<BankServiceDto> getBankServiceById(@PathVariable Long id) {
        BankServiceDto bankService = bankServiceService.getBankServiceById(id);
        return (bankService != null) ? new ResponseEntity<>(bankService, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("post/{id}")
    public ResponseEntity<BankServiceDto> createBankService(@RequestBody BankServiceDto bankServiceDto) {
        BankServiceDto createdBankService = bankServiceService.createBankService(bankServiceDto);
        return new ResponseEntity<>(createdBankService, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBankServiceById(@PathVariable Long id) {
        bankServiceService.deleteBankServiceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}