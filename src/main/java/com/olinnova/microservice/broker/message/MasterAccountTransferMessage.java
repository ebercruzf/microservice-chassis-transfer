package com.olinnova.microservice.broker.message;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class MasterAccountTransferMessage {

    private LocalDate registerDate;
    private String acountId;
    private String tranferID;
    private String clientID;
    private String message;

}

