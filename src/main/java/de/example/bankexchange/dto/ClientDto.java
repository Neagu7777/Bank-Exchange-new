package de.example.bankexchange.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ClientDto {
    private Long id;
    private Long managerId;
    private String status;
    private String taxCode;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors, getters, setters


}
