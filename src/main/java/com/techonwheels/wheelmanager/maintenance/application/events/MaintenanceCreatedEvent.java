package com.techonwheels.wheelmanager.maintenance.application.events;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceCreatedEvent {
    private String maintenanceId;
    private String maintenanceName;
    private String maintenanceDetail;
    private BigDecimal maintenancePrice;
    private Address addressMaintenance;
    private String maintenanceVehicleTypeId;
}
