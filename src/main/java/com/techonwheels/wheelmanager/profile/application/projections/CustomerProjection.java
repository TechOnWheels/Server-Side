package com.techonwheels.wheelmanager.profile.application.projections;

import com.techonwheels.wheelmanager.profile.application.queries.GetCustomerByIdQuery;
import com.techonwheels.wheelmanager.profile.application.queries.GetCustomersQuery;
import com.techonwheels.wheelmanager.profile.domain.data.Customer;
import com.techonwheels.wheelmanager.profile.domain.dto.response.CustomerResponse;
import com.techonwheels.wheelmanager.profile.domain.repositories.CustomerRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerProjection {
    private final CustomerRepository customerRepository;
    
    public CustomerProjection(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @QueryHandler
    public List<CustomerResponse> handle(GetCustomersQuery getCustomersQuery) {
        List<Customer> customers = customerRepository.findAll();
        
        List<CustomerResponse> customerResponses = customers.stream()
                .map(customer -> CustomerResponse
                        .builder()
                        .customerId(customer.getCustomerId())
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
    
    @QueryHandler
    public Optional<CustomerResponse> handle(GetCustomerByIdQuery getCustomerByIdQuery) {
        Optional<Customer> customer = customerRepository.findById(getCustomerByIdQuery.customerId);
        Optional<CustomerResponse> customerResponse = customer.map(customerResponse1 -> CustomerResponse
                .builder()
                .customerId(customerResponse1.getCustomerId())
                .name(customerResponse1.getName())
                .email(customerResponse1.getEmail())
                .phone(customerResponse1.getPhone())
                .password(customerResponse1.getPassword())
                .address(customerResponse1.getAddress())
                .qualification(customerResponse1.getQualification())
                .build());
        return customerResponse;
    }
}