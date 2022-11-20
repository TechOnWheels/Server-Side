package com.techonwheels.wheelmanager.maintenance.domain.dto.request;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MaintenanceRequest {
    private String maintenanceName;
    private String maintenanceDetail;
    private BigDecimal maintenancePrice;
    private Address addressMaintenance;
    private String maintenanceVehicleTypeId;
}
