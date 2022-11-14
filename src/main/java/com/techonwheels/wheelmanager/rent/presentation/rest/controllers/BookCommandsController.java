package com.techonwheels.wheelmanager.rent.presentation.rest.controllers;

import com.techonwheels.wheelmanager.rent.application.commands.CreateBookCommand;
import com.techonwheels.wheelmanager.rent.domain.dto.request.BookRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/booking")
public class BookCommandsController {
    private final CommandGateway commandGateway;
    
    public BookCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    public String addBook(@RequestBody BookRequest bookRequest) {
        CreateBookCommand createBookCommand =
                CreateBookCommand
                        .builder()
                        .bookId(UUID.randomUUID().toString())
                        .startDate(bookRequest.getStartDate())
                        .endDate(bookRequest.getEndDate())
                        .price(bookRequest.getPrice())
                        .rentFee(bookRequest.getRentFee())
                        .bookCustomerId(bookRequest.getBookCustomerId())
                        .bookVehicleId(bookRequest.getBookVehicleId())
                        .build();
        String result = commandGateway.sendAndWait(createBookCommand);
        return result;
    }
}
