package de.example.bankexchange.service;

import de.example.bankexchange.entity.Agreement;
import de.example.bankexchange.repository.AgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgreementService {

    @Autowired
    private AgreementRepository agreementRepository;

    // Метод для получения всех соглашений
    public List<Agreement> getAllAgreements() {
        return agreementRepository.findAll();
    }

    // Метод для получения соглашения по ID
    public Agreement getAgreementById(Long id) {
        Optional<Agreement> optionalAgreement = agreementRepository.findById(id);
        return optionalAgreement.orElse(null);
        // Возвращаем соглашение по id или null, если не найдено
    }

    // Метод для создания нового соглашения
    public Agreement createAgreement(Agreement agreement) {
        return agreementRepository.save(agreement);
        // Возвращаем созданное соглашение
    }

    // Метод для удаления соглашения по ID
    public void deleteAgreementById(Long id) {
        agreementRepository.deleteById(id);
        // Удаляем соглашение по id
    }

    // Другие методы для бизнес-логики соглашений
}