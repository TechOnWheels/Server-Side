package com.techonwheels.wheelmanager.community.infrastructure.data;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "favorites")
@Entity
public class Favorite {
    @Id
    private String favoriteId;
    @Column(name = "favorite_selected", nullable = false)
    private Boolean favoriteSelected;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favorite_customer_id", referencedColumnName = "customerId")
    private Customer favoriteCustomerId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favorite_vehicle_id", referencedColumnName = "vehicleId")
    private Vehicle favoriteVehicleId;
}
