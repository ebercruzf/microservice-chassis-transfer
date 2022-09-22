package com.olinnova.microservice.command.service;

import java.time.LocalDate;

public interface IMasterTransferDisableService {

    public boolean disableTransferTemp(String tranferId, LocalDate date);
}
