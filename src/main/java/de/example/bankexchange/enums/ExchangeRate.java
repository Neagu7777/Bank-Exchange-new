package de.example.bankexchange.enums;

import java.math.BigDecimal;

public enum ExchangeRate {
    USD_TO_EUR(BigDecimal.valueOf(0.85), BigDecimal.valueOf(1.18)),
    USD_TO_GBP(BigDecimal.valueOf(0.72), BigDecimal.valueOf(1.39)),
    USD_TO_CZK(BigDecimal.valueOf(21.88), BigDecimal.valueOf(0.046)),
    EUR_TO_GBP(BigDecimal.valueOf(0.85 / 0.72), BigDecimal.valueOf(1.39 / 0.85)),
    EUR_TO_CZK(BigDecimal.valueOf(21.88 / 0.85), BigDecimal.valueOf(0.046 / 0.85)),
    GBP_TO_CZK(BigDecimal.valueOf(21.88 / 0.72), BigDecimal.valueOf(0.046 / 0.72));

    private final BigDecimal rate;
    private final BigDecimal reverseRate;

    ExchangeRate(BigDecimal rate, BigDecimal reverseRate) {
        this.rate = rate;
        this.reverseRate = reverseRate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getReverseRate() {
        return reverseRate;
    }
}
