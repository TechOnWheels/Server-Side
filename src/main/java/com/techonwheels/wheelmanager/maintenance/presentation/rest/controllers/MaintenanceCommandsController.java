package com.techonwheels.wheelmanager.maintenance.presentation.rest.controllers;

import com.techonwheels.wheelmanager.maintenance.application.commands.CreateMaintenanceCommand;
import com.techonwheels.wheelmanager.maintenance.domain.dto.request.MaintenanceRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Tag(name = "Maintenances Commands")
@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceCommandsController {
    private final CommandGateway commandGateway;
    
    public MaintenanceCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    @Operation(summary = "Post Maintenance")
    public String addMaintenance(@RequestBody MaintenanceRequest maintenanceRequest) {
        CreateMaintenanceCommand createMaintenanceCommand =
                CreateMaintenanceCommand
                        .builder()
                        .maintenanceId(UUID.randomUUID().toString())
                        .maintenanceName(maintenanceRequest.getMaintenanceName())
                        .maintenanceDetail(maintenanceRequest.getMaintenanceDetail())
                        .maintenancePrice(maintenanceRequest.getMaintenancePrice())
                        .addressMaintenance(maintenanceRequest.getAddressMaintenance())
                        .maintenanceVehicleTypeId(maintenanceRequest.getMaintenanceVehicleTypeId())
                        .build();
        String result = commandGateway.sendAndWait(createMaintenanceCommand);
        return result;
    }
}
