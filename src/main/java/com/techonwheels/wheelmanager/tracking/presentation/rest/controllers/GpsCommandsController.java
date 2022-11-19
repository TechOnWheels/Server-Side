package com.techonwheels.wheelmanager.tracking.presentation.rest.controllers;

import com.techonwheels.wheelmanager.tracking.application.commands.CreateGpsCommand;
import com.techonwheels.wheelmanager.tracking.domain.dto.request.GpsRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/gps")
public class GpsCommandsController {
    private final CommandGateway commandGateway;
    
    public GpsCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    public String addGps(@RequestBody GpsRequest gpsRequest) {
        CreateGpsCommand createGpsCommand =
                CreateGpsCommand
                        .builder()
                        .gpsId(UUID.randomUUID().toString())
                        .latitudeGps(gpsRequest.getLatitudeGps())
                        .longitudeGps(gpsRequest.getLongitudeGps())
                        .addressGps(gpsRequest.getAddressGps())
                        .gpsVehicleOwnerId(gpsRequest.getGpsVehicleOwnerId())
                        .build();
        String result = commandGateway.sendAndWait(createGpsCommand);
        return result;
    }
}
