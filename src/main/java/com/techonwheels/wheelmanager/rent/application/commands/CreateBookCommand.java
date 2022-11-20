package com.techonwheels.wheelmanager.rent.application.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class CreateBookCommand {
    @TargetAggregateIdentifier
    private String bookId;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private BigDecimal rentFee;
    private String bookCustomerId;
    private String bookVehicleId;
}
