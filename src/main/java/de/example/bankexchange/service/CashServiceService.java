package de.example.bankexchange.service;

import de.example.bankexchange.dto.CashServiceDto;
import de.example.bankexchange.entity.CashService;
import de.example.bankexchange.enums.TransactionType;
import de.example.bankexchange.repository.CashServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CashServiceService {
    private final CashServiceRepository cashServiceRepository;

    public CashServiceService(CashServiceRepository cashServiceRepository) {
        this.cashServiceRepository = cashServiceRepository;
    }

    public List<CashServiceDto> getAllCashServices() {
        List<CashService> cashServices = cashServiceRepository.findAll();
        return cashServices.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CashServiceDto getCashServiceById(Long id) {
        return cashServiceRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public CashServiceDto createCashService(CashServiceDto cashServiceDto) {
        CashService cashService = convertToEntity(cashServiceDto);
        cashService = cashServiceRepository.save(cashService);
        return convertToDto(cashService);
    }

    public CashServiceDto updateCashService(Long id, CashServiceDto updatedCashServiceDto) {
        CashService existingCashService = cashServiceRepository.findById(id)
                .orElse(null);
        if (existingCashService != null) {
            CashService updatedCashService = convertToEntity(updatedCashServiceDto);
            updatedCashService.setAccountId(existingCashService.getAccountId());
            updatedCashService = cashServiceRepository.save(updatedCashService);
            return convertToDto(updatedCashService);
        }
        return null;
    }

    public void deleteCashServiceById(Long id) {
        cashServiceRepository.deleteById(id);
    }

    private CashServiceDto convertToDto(CashService cashService) {
        CashServiceDto cashServiceDto = new CashServiceDto();
        cashServiceDto.setId(cashService.getAccountId());
        cashServiceDto.setType(String.valueOf(cashService.getType()));
        cashServiceDto.setAmount(cashService.getAmount());
        cashServiceDto.setDescription(cashService.getDescription());
        cashServiceDto.setDate(cashService.getDate());
        return cashServiceDto;
    }

    private CashService convertToEntity(CashServiceDto cashServiceDto) {
        CashService cashService = new CashService();
        cashService.setType(TransactionType.valueOf(cashServiceDto.getType()));
        cashService.setAmount(cashServiceDto.getAmount());
        cashService.setDescription(cashServiceDto.getDescription());
        cashService.setDate(cashServiceDto.getDate());
        return cashService;
    }
}