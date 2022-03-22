package com.example.awssqs.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class AwsSQSListenerService {

    private final Logger LOG = LoggerFactory.getLogger(AwsSQSListenerService.class);


    @SqsListener(value = "queue_test", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    private void listener(String message){
        LOG.info("Message recived from SQS Queue: {} ", message);
    }


}
