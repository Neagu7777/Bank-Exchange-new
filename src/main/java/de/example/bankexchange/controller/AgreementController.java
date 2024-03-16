package de.example.bankexchange.controller;


import de.example.bankexchange.dto.AgreementDto;
import de.example.bankexchange.entity.Account;
import de.example.bankexchange.entity.Agreement;
import de.example.bankexchange.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@Controller
@RestController
@RequiredArgsConstructor
@EnableScheduling
@RequestMapping("/api/agreements")

public class AgreementController {

    private final AgreementService agreementService;

    @GetMapping("all")
    public ResponseEntity<List<Agreement>> getAllAgreements() {
        List<Agreement> agreements = agreementService.getAllAgreements();
        return new ResponseEntity<>(agreements, HttpStatus.OK);
    }

    @GetMapping("info/{id}")
    public ResponseEntity<Agreement> getAgreementById(@PathVariable Long id) {
        Agreement agreement = agreementService.getAgreementById(id);
        return (agreement != null) ? new ResponseEntity<>(agreement, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("post/{id}")
    public ResponseEntity<Agreement> createAgreement(@RequestBody Agreement agreement) {
        Agreement createdAgreement = agreementService.createAgreement(agreement);
        return new ResponseEntity<>(createdAgreement, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteAgreementById(@PathVariable Long id) {
        agreementService.deleteAgreementById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}