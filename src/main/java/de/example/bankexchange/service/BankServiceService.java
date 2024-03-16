package de.example.bankexchange.service;

import de.example.bankexchange.dto.BankServiceDto;
import de.example.bankexchange.entity.BankService;
import de.example.bankexchange.enums.AccountServiceType;
import de.example.bankexchange.repository.BankServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceService {

    private final BankServiceRepository bankServiceRepository;

    public BankServiceService(BankServiceRepository bankServiceRepository) {
        this.bankServiceRepository = bankServiceRepository;
    }

    public List<BankServiceDto> getAllBankServices() {
        List<BankService> bankServices = bankServiceRepository.findAll();
        return bankServices.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public BankServiceDto getBankServiceById(Long id) {
        return bankServiceRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public BankServiceDto createBankService(BankServiceDto bankServiceDto) {
        BankService bankService = convertToEntity(bankServiceDto);
        bankService = bankServiceRepository.save(bankService);
        return convertToDto(bankService);
    }

    public void deleteBankServiceById(Long id) {
        bankServiceRepository.deleteById(id);
    }

    private BankServiceDto convertToDto(BankService bankService) {
        BankServiceDto bankServiceDto = new BankServiceDto();
        bankServiceDto.setId(bankService.getId());
        bankServiceDto.setName(String.valueOf(bankService.getName()));
        bankServiceDto.setServiceType(bankService.getServiceType());
        bankServiceDto.setCreatedAt(bankService.getCreatedAt());
        return bankServiceDto;
    }

    private BankService convertToEntity(BankServiceDto bankServiceDto) {
        BankService bankService = new BankService();
        bankService.setName(AccountServiceType.valueOf(bankServiceDto.getName()));
        bankService.setServiceType(bankServiceDto.getServiceType());
        // Assuming createdAt is set automatically upon creation
        return bankService;
    }
}