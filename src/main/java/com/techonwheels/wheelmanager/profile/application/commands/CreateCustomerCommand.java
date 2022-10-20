package com.techonwheels.wheelmanager.profile.application.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateCustomerCommand {
    @TargetAggregateIdentifier
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private Integer qualification;
}
