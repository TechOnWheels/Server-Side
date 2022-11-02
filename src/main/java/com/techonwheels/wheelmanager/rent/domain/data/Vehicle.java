package com.techonwheels.wheelmanager.rent.domain.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "vehicle_status", nullable = false, length = 50)
    private String status;
    @Column(name = "brand", nullable = false, length = 50)
    private String brand;
    @Column(name = "vehicle_type", nullable = false, length = 50)
    private String type;
    @Column(name = "vehicle_owner_id", nullable = false, length = 50)
    private String ownerId;
}
