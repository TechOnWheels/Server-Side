package com.techonwheels.wheelmanager.rent.application.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCreatedEvent {
    private String bookId;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private BigDecimal rentFee;
    private String bookCustomerId;
    private String bookVehicleId;
}
