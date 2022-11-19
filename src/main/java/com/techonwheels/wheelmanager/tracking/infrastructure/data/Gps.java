package com.techonwheels.wheelmanager.tracking.infrastructure.data;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "gps")
@Entity
public class Gps {
    @Id
    private String gpsId;
    @Column(name = "latitude_gps", nullable = false)
    private Double latitudeGps;
    @Column(name = "longitude_gps", nullable = false)
    private Double longitudeGps;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress",
                    column = @Column(name = "street_address", nullable = false)),
            @AttributeOverride(name = "city",
                    column = @Column(name = "city_address", nullable = false, length = 50)),
            @AttributeOverride(name = "country",
                    column = @Column(name = "country_address", nullable = false, length = 50))
    })
    private Address addressGps;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gps_vehicle_id", referencedColumnName = "vehicleId")
    private Vehicle gpsVehicleId;
}
