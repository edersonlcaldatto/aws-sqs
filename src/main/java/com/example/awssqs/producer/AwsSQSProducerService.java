package com.example.awssqs.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class AwsSQSProducerService {

    private static final Logger LOG = LoggerFactory.getLogger(AwsSQSProducerService.class);

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String sqsEndPoint;

    public void sendMessage(String msg) {
        queueMessagingTemplate.send(sqsEndPoint, MessageBuilder.withPayload(msg).build());
        LOG.info("mensagem {} envida para fila ", msg);
    }



}
