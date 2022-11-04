package com.techonwheels.wheelmanager.rent.domain.dto.response;

import com.techonwheels.wheelmanager.profile.domain.data.Customer;
import com.techonwheels.wheelmanager.rent.domain.data.VehicleType;
import com.techonwheels.wheelmanager.rent.domain.valueobjects.Brand;
import com.techonwheels.wheelmanager.rent.domain.valueobjects.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleResponse {
    private String vehicleId;
    private String vehicleName;
    private String imageURL;
    private String description;
    private Double price;
    private Double qualification;
    private Status status;
    private Brand brand;
    private VehicleType vehicleTypeId;
    private Customer ownerId;
}
