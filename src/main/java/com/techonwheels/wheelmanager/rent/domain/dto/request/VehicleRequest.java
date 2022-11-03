package com.techonwheels.wheelmanager.rent.domain.dto.request;

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
    private String status;
    private String brand;
    private String type;
    private String ownerId;
}
