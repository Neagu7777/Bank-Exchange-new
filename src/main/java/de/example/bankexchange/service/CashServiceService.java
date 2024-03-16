package de.example.bankexchange.service;

import de.example.bankexchange.dto.CashServiceDto;
import de.example.bankexchange.entity.CashService;
import de.example.bankexchange.repository.CashServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CashServiceService {

           @Autowired
        private CashServiceRepository cashServiceRepository;



    // Другие методы остаются без изменений

    public List<CashServiceDto> getAllCashServices() {
        List<CashService> cashServices = cashServiceRepository.findAll();
        return convertToDtoList(cashServices);
    }

    // Остальные методы

    private List<CashServiceDto> convertToDtoList(List<CashService> cashServices) {
        return cashServices.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
        public CashServiceDto depositCash(Long accountId, double amount) {
            CashService cashService = cashServiceRepository.findByAccountId(accountId)
                    .orElseThrow(() -> new RuntimeException("Счет кассы не найден"));

            // Обновляем баланс после успешного внесения наличных
            BigDecimal currentAmount = cashService.getAmount();
            BigDecimal newAmount = currentAmount.add(BigDecimal.valueOf(amount));
            cashService.setAmount(newAmount);

            // Сохраняем обновленный объект cashService
            cashServiceRepository.save(cashService);

            // Возвращаем результат в виде CashServiceDto
            return convertToDto(cashService);
        }

        // Другие методы остаются без изменений

        private CashServiceDto convertToDto(CashService cashService) {
            CashServiceDto cashServiceDto = new CashServiceDto();
            cashServiceDto.setId(cashService.getId());
            cashServiceDto.setType(cashService.getType());
            cashServiceDto.setAmount(cashService.getAmount());
            cashServiceDto.setDescription(cashService.getDescription());
            cashServiceDto.setDate(cashService.getDate());
            // Другие присвоения полей
            return cashServiceDto;
        }

        private CashService convertToEntity(CashServiceDto cashServiceDto) {
            CashService cashService = new CashService();
            cashService.setId(cashServiceDto.getId());
            cashService.setType(cashServiceDto.getType());
            cashService.setAmount(cashServiceDto.getAmount());
            cashService.setDescription(cashServiceDto.getDescription());
            cashService.setDate(cashServiceDto.getDate());
            // Другие присвоения полей
            return cashService;
        }

    public CashServiceDto withdrawCash(long l, int i) {
        return null;
    }

    public CashServiceDto createCashService(CashServiceDto cashServiceDto) {
        return cashServiceDto;
    }

    public double getAccountBalance(Long accountId) {
        return 0;
    }
//    public List<CashServiceDto> getAllCashServices() {
//        return null;
//    }

    public CashServiceDto withdrawCash(Long accountId, double amount) {
        return null;
    }

    public CashServiceDto updateCashService(Long id, CashServiceDto updatedCashService) {
        return updatedCashService;
    }

    public void deleteCashServiceById(Long id) {
    }

    public CashServiceDto getCashServiceById(Long id) {
        return null;
    }

    public CashServiceDto withdrawCash(CashServiceDto request) {
        return request;
    }
}