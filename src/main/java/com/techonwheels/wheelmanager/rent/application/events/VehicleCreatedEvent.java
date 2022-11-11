package com.techonwheels.wheelmanager.rent.application.events;

import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Brand;
import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleCreatedEvent {
    private String vehicleId;
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
