package com.techonwheels.wheelmanager.rent.presentation.rest.controllers;

import com.techonwheels.wheelmanager.rent.application.commands.CreateBookCommand;
import com.techonwheels.wheelmanager.rent.domain.dto.request.BookRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Tag(name = "Booking Commands")
@RestController
@RequestMapping("/api/booking")
public class BookCommandsController {
    private final CommandGateway commandGateway;
    
    public BookCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    @Operation(summary = "Post Booking")
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
