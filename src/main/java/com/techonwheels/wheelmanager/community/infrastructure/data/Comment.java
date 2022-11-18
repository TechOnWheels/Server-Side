package com.techonwheels.wheelmanager.community.infrastructure.data;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "comments")
@Entity
public class Comment {
    @Id
    private String commentId;
    @Column(name = "comment_detail", nullable = false)
    private String commentDetail;
    @Column(name = "publication_date", nullable = false)
    private Date publicationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_customer_id", referencedColumnName = "customerId")
    private Customer commentCustomerId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_vehicle_id", referencedColumnName = "vehicleId")
    private Vehicle commentVehicleId;
}
