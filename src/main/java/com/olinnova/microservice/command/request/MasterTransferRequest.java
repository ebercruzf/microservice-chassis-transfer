package com.olinnova.microservice.command.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterTransferRequest {
    private String accountId;
    private String transferID;
    private String clientID;
    private String message;
    private LocalDate createDate;
}
