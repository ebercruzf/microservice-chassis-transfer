package com.olinnova.microservice.command.service.impl;

import com.olinnova.microservice.command.service.IMasterTransferDisableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MasterTransferDisableServiceImpl implements IMasterTransferDisableService {
    private static final Logger LOG = LoggerFactory.getLogger(MasterTransferDisableServiceImpl.class);
    @Override
    public boolean disableTransferTemp(String transferId, LocalDate requestDate) {

        LOG.debug("Disabling transfer account : {}, effective date : {} will take few seconds simulation."
                , transferId, requestDate );
        System.out.println("MDisabling transfer account ######### 11 : {} " + transferId + " " +  requestDate);
        //simulating someone delay
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
