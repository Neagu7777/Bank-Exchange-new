package de.example.bankexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class BankExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankExchangeApplication.class, args);
    }
}