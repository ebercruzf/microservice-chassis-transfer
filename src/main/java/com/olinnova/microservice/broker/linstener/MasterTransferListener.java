package com.olinnova.microservice.broker.linstener;

import com.olinnova.microservice.broker.message.MasterAccountTranferResponseMessage;
import com.olinnova.microservice.broker.message.MasterAccountTransferMessage;
import com.olinnova.microservice.command.service.IMasterTransferDisableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MasterTransferListener {

    private static final Logger LOG = LoggerFactory.getLogger( MasterTransferListener.class);

    @Autowired
    private IMasterTransferDisableService iMasterTransferDisableService;

    @KafkaListener(topics =  "c.transfermessage")
    @SendTo (value = "c.transfermessage.response")
    public MasterAccountTranferResponseMessage listerMasterTransferResponse(MasterAccountTransferMessage message){
        LOG.debug("[Async] Start listener from message broker, disabling master transfer");
        System.out.println("MasterTransferListener ######### 10 : {} " + message.getAcountId() + " " +  message.getRegisterDate());

        iMasterTransferDisableService.disableTransferTemp(message.getAcountId(), message.getRegisterDate());

        var performanceApprovedTransferMessage = new MasterAccountTranferResponseMessage();
        performanceApprovedTransferMessage.setTranferID(message.getAcountId());
        performanceApprovedTransferMessage.setAcountId(message.getAcountId());
        performanceApprovedTransferMessage.setMessage("Done simulating master MasterTransferListener with succes: Good Lucky" + message.getTranferID());


                System.out.println("MasterTransferListener ######### 30 :  " + message.getAcountId() + " " +  message.getRegisterDate());
                LOG.debug("[Async] Finish listening from message broker, disabling MasterTransferListener");
        return performanceApprovedTransferMessage;

    }


}
