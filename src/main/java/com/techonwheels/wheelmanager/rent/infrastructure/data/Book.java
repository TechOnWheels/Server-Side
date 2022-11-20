package com.techonwheels.wheelmanager.rent.infrastructure.data;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "bookings")
@Entity
public class Book {
    @Id
    private String bookId;
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "rent_fee", nullable = false)
    private BigDecimal rentFee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_customer_id", referencedColumnName = "customerId")
    private Customer bookCustomerId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_vehicle_id", referencedColumnName = "vehicleId")
    private Vehicle bookVehicleId;
}
