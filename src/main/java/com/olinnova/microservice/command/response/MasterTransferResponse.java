package com.olinnova.microservice.command.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MasterTransferResponse {
    private String accountId;
    private String transferID;
    private String clientID;
    private String message;
    private LocalDate createDate;
}
