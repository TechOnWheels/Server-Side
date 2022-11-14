package com.techonwheels.wheelmanager.rent.domain.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class BookRequest {
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private BigDecimal rentFee;
    private String bookCustomerId;
    private String bookVehicleId;
}
