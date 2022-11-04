package com.techonwheels.wheelmanager.rent.domain.data;

import com.techonwheels.wheelmanager.profile.domain.data.Customer;
import com.techonwheels.wheelmanager.rent.domain.valueobjects.Brand;
import com.techonwheels.wheelmanager.rent.domain.valueobjects.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "vehicles")
@Entity
public class Vehicle {
    @Id
    private String vehicleId;
    @Column(name = "vehicle_name", nullable = false, length = 50)
    private String vehicleName;
    @Column(name = "image_url", nullable = false, length = 50)
    private String imageURL;
    @Column(name = "description", nullable = false, length = 50)
    private String description;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "qualification", nullable = false)
    private Double qualification;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "statusVehicle",
                    column = @Column(name = "vehicle_status", nullable = false, length = 50))
    })
    private Status status;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "brandName",
                    column = @Column(name = "brand_name", nullable = false, length = 50))
    })
    private Brand brand;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_type_id", referencedColumnName = "typeId")
    private VehicleType vehicleTypeId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_owner_id", referencedColumnName = "customerId")
    private Customer ownerId;
}
