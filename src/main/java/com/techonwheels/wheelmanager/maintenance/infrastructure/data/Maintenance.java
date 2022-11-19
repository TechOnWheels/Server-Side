package com.techonwheels.wheelmanager.maintenance.infrastructure.data;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import com.techonwheels.wheelmanager.rent.infrastructure.data.VehicleType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "maintenances")
@Entity
public class Maintenance {
    @Id
    private String maintenanceId;
    @Column(name = "maintenance_name", nullable = false, length = 150)
    private String maintenanceName;
    @Column(name = "maintenance_detail", nullable = false)
    private String maintenanceDetail;
    @Column(name = "maintenance_price", nullable = false)
    private BigDecimal maintenancePrice;
    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress",
                    column = @Column(name = "street_address", nullable = false)),
            @AttributeOverride(name = "city",
                    column = @Column(name = "city_address", nullable = false, length = 50)),
            @AttributeOverride(name = "country",
                    column = @Column(name = "country_address", nullable = false, length = 50))
    })
    private Address addressMaintenance;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maintenance_type_id", referencedColumnName = "typeId")
    private VehicleType maintenanceVehicleTypeId;
}
