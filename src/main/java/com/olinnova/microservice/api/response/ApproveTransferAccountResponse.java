package com.olinnova.microservice.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApproveTransferAccountResponse {

    private String account_id;
    private String message;
}
