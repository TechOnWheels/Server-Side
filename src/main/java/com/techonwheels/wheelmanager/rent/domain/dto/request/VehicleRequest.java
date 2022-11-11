package com.techonwheels.wheelmanager.rent.domain.dto.request;

import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Brand;
import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleRequest {
    private String vehicleName;
    private String imageURL;
    private String description;
    private Double price;
    private Double qualification;
    private Status status;
    private Brand brand;
    private String vehicleTypeId;
    private String ownerId;
}
