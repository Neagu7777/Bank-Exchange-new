package de.example.bankexchange.controller;


import de.example.bankexchange.entity.Agreement;
import de.example.bankexchange.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/agreements")

public class AgreementController {

    private final AgreementService agreementService;
    private static final Logger logger = LoggerFactory.getLogger(AgreementController.class);

    @GetMapping("/all")
    public ResponseEntity<List<Agreement>> getAllAgreements() {
        try {
            List<Agreement> agreements = agreementService.getAllAgreements();
            return new ResponseEntity<>(agreements, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error occurred while fetching all agreements: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Agreement> getAgreementById(@PathVariable Long id) {
        Agreement agreement = agreementService.getAgreementById(id);
        return (agreement != null) ? ResponseEntity.ok(agreement) : ResponseEntity.notFound().build();
    }

    @PostMapping("/post")
    public ResponseEntity<Agreement> createAgreement(@RequestBody Agreement agreement) {
        Agreement createdAgreement = agreementService.createAgreement(agreement);
        return new ResponseEntity<>(createdAgreement, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAgreementById(@PathVariable Long id) {
        agreementService.deleteAgreementById(id);
        return ResponseEntity.noContent().build();
    }
}