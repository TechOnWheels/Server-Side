package com.techonwheels.wheelmanager.rent.presentation.rest.controllers;

import com.techonwheels.wheelmanager.rent.application.commands.CreateVehicleTypeCommand;
import com.techonwheels.wheelmanager.rent.domain.dto.request.VehicleTypeRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/types")
public class VehicleTypeCommandsController {
    private final CommandGateway commandGateway;
    
    public VehicleTypeCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    public String addVehicleType(@RequestBody VehicleTypeRequest vehicleTypeRequest) {
        CreateVehicleTypeCommand createVehicleTypeCommand =
                CreateVehicleTypeCommand
                        .builder()
                        .typeId(UUID.randomUUID().toString())
                        .typeName(vehicleTypeRequest.getTypeName())
                        .build();
        String result = commandGateway.sendAndWait(createVehicleTypeCommand);
        return result;
    }
}
