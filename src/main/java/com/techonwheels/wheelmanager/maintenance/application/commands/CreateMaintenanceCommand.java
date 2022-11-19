package com.techonwheels.wheelmanager.maintenance.application.commands;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class CreateMaintenanceCommand {
    @TargetAggregateIdentifier
    private String maintenanceId;
    private String maintenanceName;
    private String maintenanceDetail;
    private BigDecimal maintenancePrice;
    private Address addressMaintenance;
    private String maintenanceVehicleTypeId;
}
