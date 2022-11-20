package com.techonwheels.wheelmanager.tracking.presentation.rest.controllers;

import com.techonwheels.wheelmanager.tracking.application.commands.CreateGpsCommand;
import com.techonwheels.wheelmanager.tracking.domain.dto.request.GpsRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Tag(name = "Booking Commands")
@RestController
@RequestMapping("/api/gps")
public class GpsCommandsController {
    private final CommandGateway commandGateway;
    
    public GpsCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    @Operation(summary = "Post Gps")
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
