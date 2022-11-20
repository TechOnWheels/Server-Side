package com.techonwheels.wheelmanager.rent.domain.dto.response;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.infrastructure.data.VehicleType;
import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Brand;
import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Status;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class VehicleResponse {
    private String vehicleId;
    private String vehicleName;
    private String imageURL;
    private String description;
    private BigDecimal price;
    private Double qualification;
    private Status status;
    private Brand brand;
    private VehicleType vehicleTypeId;
    private Customer ownerId;
}
