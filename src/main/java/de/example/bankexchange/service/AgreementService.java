package de.example.bankexchange.service;


import de.example.bankexchange.entity.Agreement;
import de.example.bankexchange.enums.ProductAgreement;
import de.example.bankexchange.repository.AgreementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.List;

@Service
public class AgreementService {

    private final AgreementRepository agreementRepository;

    public AgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    @Transactional(readOnly = true)
    public List<Agreement> getAllAgreements() {
        List<Agreement> agreements = agreementRepository.findAll();
        agreements.forEach(this::convertEnumValuesToStrings);
        return agreements;
    }

    private void convertEnumValuesToStrings(Agreement agreement) {
        try {
            agreement.setProductId(ProductAgreement.valueOf(agreement.getProductId().name()));
            agreement.setInterestRate(agreement.getInterestRate());
        } catch (IllegalArgumentException e) {
            agreement.setProductId(ProductAgreement.DEFAULT_VALUE);
            assert ProductAgreement.getDefault() != null;
            agreement.setInterestRate(ProductAgreement.getDefault().name());
        }
    }

    @Transactional(readOnly = true)
    public Agreement getAgreementById(Long id) {
        Optional<Agreement> agreementOptional = agreementRepository.findById(id);
        return agreementOptional.orElse(null);
    }

    public Agreement createAgreement(Agreement agreement) {
        return agreementRepository.save(agreement);
    }

    public void deleteAgreementById(Long id) {
        agreementRepository.deleteById(id);
    }

    // Остальные методы сервиса
}