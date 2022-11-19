package com.techonwheels.wheelmanager.profile.presentation.rest.controllers;

import com.techonwheels.wheelmanager.profile.application.commands.CreateCustomerCommand;
import com.techonwheels.wheelmanager.profile.domain.dto.request.CustomerRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Tag(name = "Customer Commands")
@RestController
@RequestMapping("/api/customers")
public class CustomerCommandsController {
    
    private final CommandGateway commandGateway;
    
    public CustomerCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    @Operation(summary = "Post Customer")
    public String addCustomer(@RequestBody CustomerRequest customerRequest) {
        CreateCustomerCommand createCustomerCommand =
                CreateCustomerCommand
                        .builder()
                        .customerId(UUID.randomUUID().toString())
                        .name(customerRequest.getName())
                        .email(customerRequest.getEmail())
                        .phone(customerRequest.getPhone())
                        .password(customerRequest.getPassword())
                        .address(customerRequest.getAddress())
                        .build();
        String result = commandGateway.sendAndWait(createCustomerCommand);
        return result;
    }
}
