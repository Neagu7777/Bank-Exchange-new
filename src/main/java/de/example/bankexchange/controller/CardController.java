package de.example.bankexchange.controller;

import de.example.bankexchange.dto.CardServiceDto;
import de.example.bankexchange.service.CardServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bank-services")
public class CardController {

    private final CardServiceService bankServiceService;

    @GetMapping("all")
    public ResponseEntity<List<CardServiceDto>> getAllBankServices() {
        List<CardServiceDto> bankServices = bankServiceService.getAllBankServices();
        return new ResponseEntity<>(bankServices, HttpStatus.OK);
    }

    @GetMapping("info/{id}")
    public ResponseEntity<CardServiceDto> getBankServiceById(@PathVariable Long id) {
        CardServiceDto bankService = bankServiceService.getBankServiceById(id);
        return (bankService != null) ? new ResponseEntity<>(bankService, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("post")
    public ResponseEntity<CardServiceDto> createBankService(@RequestBody CardServiceDto bankServiceDto) {
        CardServiceDto createdBankService = bankServiceService.createBankService(bankServiceDto);
        return new ResponseEntity<>(createdBankService, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBankServiceById(@PathVariable Long id) {
        bankServiceService.deleteBankServiceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}