package com.techonwheels.wheelmanager.profile.domain.aggregates;

import com.techonwheels.wheelmanager.profile.application.commands.CreateCustomerCommand;
import com.techonwheels.wheelmanager.profile.application.events.CustomerCreatedEvent;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Address;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Email;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Name;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CustomerAggregate {
    @AggregateIdentifier
    private String customerId;
    private Name name;
    private Email email;
    private String phone;
    private String password;
    private Address address;
    private Integer qualification;
    
    public CustomerAggregate() {
    
    }
    
    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand createCustomerCommand) {
        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent();
        BeanUtils.copyProperties(createCustomerCommand, customerCreatedEvent);
        AggregateLifecycle.apply(customerCreatedEvent);
    }
    
    
    @EventSourcingHandler
    public void on(CustomerCreatedEvent customerCreatedEvent) {
        this.customerId = customerCreatedEvent.getCustomerId();
        this.name = customerCreatedEvent.getName();
        this.email = customerCreatedEvent.getEmail();
        this.phone = customerCreatedEvent.getPhone();
        this.password = customerCreatedEvent.getPassword();
        this.address = customerCreatedEvent.getAddress();
        this.qualification = customerCreatedEvent.getQualification();
    }
}
