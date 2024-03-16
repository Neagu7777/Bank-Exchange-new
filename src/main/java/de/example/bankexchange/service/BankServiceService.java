package de.example.bankexchange.service;

import de.example.bankexchange.dto.BankServiceDto;
import de.example.bankexchange.entity.BankService;
import de.example.bankexchange.repository.BankServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BankServiceService {

    @Autowired
    private BankServiceRepository bankServiceRepository;

    // Метод для получения всех банковских услуг и преобразования в Dto
    public List<BankServiceDto> getAllBankServices() {
        List<BankService> bankServices = bankServiceRepository.findAll();
        return bankServices.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Метод для получения банковской услуги по ID и преобразования в Dto
    public BankServiceDto getBankServiceById(Long id) {
        BankService bankService = bankServiceRepository.findById(id).orElse(null);
        return (bankService != null) ? convertToDto(bankService) : null;
    }

    // Метод для создания новой банковской услуги из Dto и преобразования в Dto
    public BankServiceDto createBankService(BankServiceDto bankServiceDto) {
        BankService bankService = convertToEntity(bankServiceDto);
        BankService createdBankService = bankServiceRepository.save(bankService);
        return convertToDto(createdBankService);
    }

    // Метод для удаления банковской услуги по ID
    public void deleteBankServiceById(Long id) {
        bankServiceRepository.deleteById(id);
    }

    // Приватный метод для преобразования сущности в Dto
    private BankServiceDto convertToDto(BankService bankService) {
        BankServiceDto bankServiceDto = new BankServiceDto();
        bankServiceDto.setId(bankService.getId());
        bankServiceDto.setName(bankService.getName());
        bankServiceDto.setServiceType(bankService.getServiceType());
        bankServiceDto.setCreatedAt(bankService.getCreatedAt());
        // Другие присвоения полей
        return bankServiceDto;
    }

    // Приватный метод для преобразования Dto в сущность
    private BankService convertToEntity(BankServiceDto bankServiceDto) {
        BankService bankService = new BankService();
        bankService.setId(bankServiceDto.getId());
        bankService.setName(bankServiceDto.getName());
        bankService.setServiceType(bankServiceDto.getServiceType());
        bankService.setCreatedAt(bankServiceDto.getCreatedAt());
        // Другие присвоения полей
        return bankService;
    }
}