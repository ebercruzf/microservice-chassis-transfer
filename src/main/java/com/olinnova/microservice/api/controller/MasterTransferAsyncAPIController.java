package com.olinnova.microservice.api.controller;

import com.olinnova.microservice.api.request.ApproveTransferAccountRequest;
import com.olinnova.microservice.api.response.ApproveTransferAccountResponse;
import com.olinnova.microservice.command.service.impl.MasterTransferAsyncServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * A Microservice example is response an account.
 * This microservice implements an example of communications and
 * execution ASYNC, using Listener  whith apache Kafka.
 * @author Eber Cruz  www.ebercruz.com
 */

@RestController
@RequestMapping("/api/transfer/async")
public class MasterTransferAsyncAPIController {

    @Autowired
    private MasterTransferAsyncServiceImpl masterTransferAsyncService;

    @PostMapping(value = "/{account_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApproveTransferAccountResponse> approveTransferAccount(
            @PathVariable(name = "account_id", required = true) String accountId,
            @RequestBody(required = true) ApproveTransferAccountRequest request){

        masterTransferAsyncService.approveTransferFinish(accountId, request.getRegisterDate());

        // dummy reponse
        var responseBody = new ApproveTransferAccountResponse();
        responseBody.setAccount_id(accountId);
        responseBody.setMessage("Done publishing termination ASYNC approval ");

        return ResponseEntity.ok().body(responseBody);

    }

}
