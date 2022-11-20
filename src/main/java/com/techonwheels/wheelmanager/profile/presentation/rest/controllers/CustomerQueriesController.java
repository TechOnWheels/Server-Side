package com.techonwheels.wheelmanager.profile.presentation.rest.controllers;

import com.techonwheels.wheelmanager.profile.application.queries.GetCustomerByEmailAndPasswordQuery;
import com.techonwheels.wheelmanager.profile.application.queries.GetCustomerByIdQuery;
import com.techonwheels.wheelmanager.profile.application.queries.GetCustomersQuery;
import com.techonwheels.wheelmanager.profile.domain.dto.response.CustomerResponse;
import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Email;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Tag(name = "Customer Queries")
@RestController
@RequestMapping("/api/customers")
public class CustomerQueriesController {
    private final QueryGateway queryGateway;
    
    public CustomerQueriesController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }
    
    @GetMapping
    @Operation(summary = "Get All Customers")
    public List<CustomerResponse> getAllCustomers() {
        GetCustomersQuery getCustomersQuery = new GetCustomersQuery();
        List<CustomerResponse> customerResponses = queryGateway.query(getCustomersQuery,
                ResponseTypes.multipleInstancesOf(CustomerResponse.class)).join();
        return customerResponses;
    }
    
    @GetMapping("/{customerId}")
    @Operation(summary = "Get Customers By Id")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String customerId) {
        GetCustomerByIdQuery getCustomerByIdQuery = new GetCustomerByIdQuery(customerId);
        Optional<CustomerResponse> customerResponse = queryGateway.query(getCustomerByIdQuery,
                ResponseTypes.optionalInstanceOf(CustomerResponse.class)).join();
        return new ResponseEntity<CustomerResponse>(customerResponse.get(), HttpStatus.OK);
    }
    
    @GetMapping("/logging")
    @Operation(summary = "Logging")
    public ResponseEntity<CustomerResponse> getCustomerByEmailAndPassword(@RequestParam(name = "email") String email,
                                                                          @RequestParam(name = "password") String password) {
        Email emailRequest = new Email();
        emailRequest.setEmail(email);
        GetCustomerByEmailAndPasswordQuery getCustomerByEmailAndPasswordQuery =
                new GetCustomerByEmailAndPasswordQuery(emailRequest,
                        password);
        Optional<CustomerResponse> customerResponse = queryGateway.query(getCustomerByEmailAndPasswordQuery,
                ResponseTypes.optionalInstanceOf(CustomerResponse.class)).join();
        return new ResponseEntity<CustomerResponse>(customerResponse.get(), HttpStatus.OK);
    }
}
