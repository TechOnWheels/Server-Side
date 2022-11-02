package com.techonwheels.wheelmanager.profile.application.handlers;

import com.techonwheels.wheelmanager.profile.application.events.CustomerCreatedEvent;
import com.techonwheels.wheelmanager.profile.domain.data.Customer;
import com.techonwheels.wheelmanager.profile.domain.repositories.CustomerRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("customer")
public class CustomerEventsHandler {
    private final CustomerRepository customerRepository;

    public CustomerEventsHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @EventHandler
    public void on(CustomerCreatedEvent customerCreatedEvent) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerCreatedEvent, customer);
        customerRepository.save(customer);
    }
}