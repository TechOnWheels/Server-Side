package com.techonwheels.wheelmanager.rent.domain.dto.response;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class BookResponse {
    private String bookId;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private BigDecimal rentFee;
    private Customer bookCustomerId;
    private Vehicle bookVehicleId;
}
