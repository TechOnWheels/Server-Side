package com.techonwheels.wheelmanager.rent.presentation.rest.controllers;

import com.techonwheels.wheelmanager.rent.application.commands.CreateVehicleCommand;
import com.techonwheels.wheelmanager.rent.domain.dto.request.VehicleRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Tag(name = "Vehicles Commands")
@RestController
@RequestMapping("/api/vehicles")
public class VehicleCommandsController {
    private final CommandGateway commandGateway;
    
    public VehicleCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    @Operation(summary = "Post Vehicle")
    public String addVehicle(@RequestBody VehicleRequest vehicleRequest) {
        CreateVehicleCommand createVehicleCommand =
                CreateVehicleCommand
                        .builder()
                        .vehicleId(UUID.randomUUID().toString())
                        .vehicleName(vehicleRequest.getVehicleName())
                        .imageURL(vehicleRequest.getImageURL())
                        .description(vehicleRequest.getDescription())
                        .price(vehicleRequest.getPrice())
                        .qualification(vehicleRequest.getQualification())
                        .status(vehicleRequest.getStatus())
                        .brand(vehicleRequest.getBrand())
                        .vehicleTypeId(vehicleRequest.getVehicleTypeId())
                        .ownerId(vehicleRequest.getOwnerId())
                        .build();
        String result = commandGateway.sendAndWait(createVehicleCommand);
        return result;
    }
}
