package com.olinnova.microservice.api.controller;


import com.olinnova.microservice.command.request.MasterTransferRequest;

import com.olinnova.microservice.command.response.MasterTransferResponse;
import com.olinnova.microservice.command.service.IMasterTransferDisableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * A Microservice example is response an account.
 * This microservice implements an example of communications and
 * execution SYNC.
 * @author Eber Cruz  www.ebercruz.com
 */

@RestController
@RequestMapping("/api/transfer/disable/master")
public class MasterTransferAPIController {

    private static final Logger LOG = LoggerFactory.getLogger(MasterTransferAPIController.class);

    @Autowired
    private IMasterTransferDisableService iMasterTransferDisableService;

    @DeleteMapping(value = "/{account_id}")
    public ResponseEntity<MasterTransferResponse> disableMasterTransfer(
            @PathVariable(name = "account_id", required = true) String accountId,
            @RequestBody(required = true)MasterTransferRequest requestBody){

        LOG.debug("Processing MasterTransferAPIController 857 by : {} :: ", requestBody.getCreateDate());
        System.out.println("MasterTransferAPIController7755 by : {} " + requestBody.toString());

        LOG.debug("[Sync] Start accessing transfer API, disabling master transfer");

        iMasterTransferDisableService.disableTransferTemp(accountId, requestBody.getCreateDate());

        //Dummy resopnse
        var responseBody = new MasterTransferResponse();
        responseBody.setTransferID(accountId);
        responseBody.setMessage("Its have done simulating disable MasterTransferAPIController for: " + accountId);

        LOG.debug("[Sync] Finished accessing transfer API, disabling master transfer");

        return ResponseEntity.ok().body(responseBody);
    }

}
