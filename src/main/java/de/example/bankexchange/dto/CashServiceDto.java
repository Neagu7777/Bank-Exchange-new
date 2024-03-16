package de.example.bankexchange.dto;

import de.example.bankexchange.entity.CashService;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Data
public class CashServiceDto {
    private Long id;
    private String type;
    private BigDecimal amount;
    private String description;
    private LocalDateTime date;
    @Getter
    private String name;

    // Getters and setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountId(long accountId) {
        // Set the account ID
    }
}
