package com.tech4.com.tracing.service;

import com.tech4.com.tracing.entity.MessageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoggingService {

    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void logData(MessageRequest messageRequest) {
        logger.info("Received data: {}", messageRequest.getMessage());
    }

    public String logError() {
String uuid = UUID.randomUUID().toString();

        logger.info("Test Successfully with UUID :  {}",uuid);
        return uuid;

    }
}
