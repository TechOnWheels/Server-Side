package com.techonwheels.wheelmanager.rent.infrastructure.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techonwheels.wheelmanager.community.infrastructure.data.Comment;
import com.techonwheels.wheelmanager.community.infrastructure.data.Favorite;
import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Brand;
import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Status;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
    private BigDecimal price;
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
    
    @JsonIgnore
    @OneToMany(mappedBy = "bookId")
    private Set<Book> bookings = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "commentId")
    private Set<Comment> comments = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "favoriteId")
    private Set<Favorite> favorites = new HashSet<>();
}
