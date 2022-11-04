package com.techonwheels.wheelmanager.profile.application.commands;

import com.techonwheels.wheelmanager.profile.domain.valueobjects.Address;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Email;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Name;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateCustomerCommand {
    @TargetAggregateIdentifier
    private String customerId;
    private Name name;
    private Email email;
    private String phone;
    private String password;
    private Address address;
}
