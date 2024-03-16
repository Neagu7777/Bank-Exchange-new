package de.example.bankexchange.impl;

import de.example.bankexchange.dto.CashServiceDto;
import de.example.bankexchange.service.CashServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashMachineServiceImpl {

    @Autowired
    private CashServiceService cashServiceService;

    public CashServiceDto withdrawCash(Long accountId, double amount) {
        // Используем CashServiceService для выдачи наличных
        return cashServiceService.withdrawCash((Long) accountId,amount);
    }

    public void depositCash(Long accountId, double amount) {
        // Используем CashServiceService для внесения наличных
        cashServiceService.depositCash(accountId, amount);
    }

    public double getAccountBalance(Long accountId) {
        // Получаем информацию о балансе счета из CashServiceService
        return cashServiceService.getAccountBalance(accountId);
    }

}