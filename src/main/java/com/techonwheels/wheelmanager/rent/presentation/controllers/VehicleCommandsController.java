package com.techonwheels.wheelmanager.rent.presentation.controllers;

import com.techonwheels.wheelmanager.rent.application.commands.CreateVehicleCommand;
import com.techonwheels.wheelmanager.rent.domain.dto.request.VehicleRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleCommandsController {
    private final CommandGateway commandGateway;
    
    public VehicleCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
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
