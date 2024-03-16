package de.example.bankexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "de.example.bankexchange")
@EnableJpaRepositories(basePackages = "de.example.bankexchange.repository")
public class BankExchangeApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankExchangeApplication.class, args);
    }
}