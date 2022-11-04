package com.techonwheels.wheelmanager.rent.domain.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "types")
@Entity
public class VehicleType {
    @Id
    private String typeId;
    @Column(name = "vehicle_type_name", nullable = false, length = 50)
    private String typeName;
    
    @JsonIgnore
    @OneToMany(mappedBy = "vehicleTypeId")
    private Set<Vehicle> vehicles = new HashSet<>();
}
