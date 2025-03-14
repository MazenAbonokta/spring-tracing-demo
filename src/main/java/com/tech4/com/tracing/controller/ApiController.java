package com.tech4.com.tracing.controller;

import com.tech4.com.tracing.entity.MessageRequest;
import com.tech4.com.tracing.service.LoggingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

private final LoggingService loggingService;

public ApiController(LoggingService loggingService) {
    this.loggingService = loggingService;
}

@GetMapping("/test")
public String getTest() {
    loggingService.logError();
     return "Test [ "+ loggingService.logError()+"]";
}

@PostMapping("/data")
public String postData(@RequestBody MessageRequest messageRequest) {
    loggingService.logData(messageRequest);
    return "Received: " + messageRequest.getMessage();
}
}