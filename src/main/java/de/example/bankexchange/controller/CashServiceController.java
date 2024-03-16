package de.example.bankexchange.controller;

import de.example.bankexchange.dto.CashServiceDto;
import de.example.bankexchange.entity.Account;
import de.example.bankexchange.impl.CashServiceServiceImpl;
import de.example.bankexchange.impl.ClientServiceImpl;
import de.example.bankexchange.service.CashServiceService;
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
@RequestMapping("/api/cash-services")
public class CashServiceController {

    @Autowired
    private final CashServiceService cashServiceService;

    @GetMapping("all")
    public ResponseEntity<List<CashServiceDto>> getAllCashServices() {
        List<CashServiceDto> cashServices = cashServiceService.getAllCashServices();
        return new ResponseEntity<>(cashServices, HttpStatus.OK);
    }


    @GetMapping("info/{id}")
    public ResponseEntity<CashServiceDto> getCashServiceById(@PathVariable Long id) {
        CashServiceDto cashService = cashServiceService.getCashServiceById(id);
        return (cashService != null) ? new ResponseEntity<>(cashService, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("post/{id}")
    public ResponseEntity<CashServiceDto> createCashService(@RequestBody CashServiceDto cashServiceDto) {
        CashServiceDto createdCashService = cashServiceService.createCashService(cashServiceDto);
        return new ResponseEntity<>(createdCashService, HttpStatus.CREATED);
    }

    @PutMapping("put/{id}")
    public ResponseEntity<CashServiceDto> updateCashService(@PathVariable Long id, @RequestBody CashServiceDto updatedCashService) {
        CashServiceDto cashService = cashServiceService.updateCashService(id, updatedCashService);
        return (cashService != null) ? new ResponseEntity<>(cashService, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCashServiceById(@PathVariable Long id) {
        cashServiceService.deleteCashServiceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}