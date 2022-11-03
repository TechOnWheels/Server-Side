package com.techonwheels.wheelmanager.rent.domain.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "vehiclestypes")
@Entity
public class VehicleType {
    @Id
    private String typeId;
    @Column(name = "vehicle_type_name", nullable = false, length = 50)
    private String type;
}
