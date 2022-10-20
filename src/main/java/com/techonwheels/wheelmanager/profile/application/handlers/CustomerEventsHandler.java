package com.techonwheels.wheelmanager.profile.application.handlers;

import com.techonwheels.wheelmanager.profile.application.events.CustomerCreatedEvent;
import com.techonwheels.wheelmanager.profile.application.queries.GetCustomersQuery;
import com.techonwheels.wheelmanager.profile.domain.data.Customer;
import com.techonwheels.wheelmanager.profile.domain.dto.CustomerResponse;
import com.techonwheels.wheelmanager.profile.domain.repositories.CustomerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerEventsHandler {
    private CustomerRepository customerRepository;
    
    public CustomerEventsHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @EventHandler
    public void on(CustomerCreatedEvent event) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(event, customer);
        customerRepository.save(customer);
    }
    
    @QueryHandler
    public List<CustomerResponse> handle(GetCustomersQuery getCustomersQuery) {
        List<Customer> customers = customerRepository.findAll();
        
        List<CustomerResponse> customerResponses = customers.stream()
                .map(customer -> CustomerResponse
                        .builder()
                        .name(customer.getName())
                        .email(customer.getEmail())
                        .phone(customer.getPhone())
                        .password(customer.getPassword())
                        .address(customer.getAddress())
                        .qualification(customer.getQualification())
                        .build())
                .collect(Collectors.toList());
        return customerResponses;
    }
}
