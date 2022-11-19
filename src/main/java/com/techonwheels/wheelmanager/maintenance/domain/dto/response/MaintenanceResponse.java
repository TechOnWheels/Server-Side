package com.techonwheels.wheelmanager.maintenance.domain.dto.response;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import com.techonwheels.wheelmanager.rent.infrastructure.data.VehicleType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MaintenanceResponse {
    private String maintenanceId;
    private String maintenanceName;
    private String maintenanceDetail;
    private BigDecimal maintenancePrice;
    private Address addressMaintenance;
    private VehicleType maintenanceVehicleTypeId;
}
