package com.olinnova.microservice.command.service;

import com.olinnova.microservice.broker.message.MasterAccountTranferResponseMessage;

import java.time.LocalDate;

public interface IMasterTransferAsyncService {

    public boolean approveTransferFinish(String tranferId, LocalDate fechaApprove);

    public void finalizeTransferApprove(MasterAccountTranferResponseMessage responseMessage);

}