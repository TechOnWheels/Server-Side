package com.techonwheels.wheelmanager.rent.presentation.rest.controllers;

import com.techonwheels.wheelmanager.rent.application.queries.GetBookByIdQuery;
import com.techonwheels.wheelmanager.rent.application.queries.GetBookingsByCustomerIdQuery;
import com.techonwheels.wheelmanager.rent.domain.dto.response.BookResponse;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
public class BookQueriesController {
    private final QueryGateway queryGateway;
    
    public BookQueriesController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }
    
    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponse> getBookingsById(@PathVariable String bookId) {
        GetBookByIdQuery getBookByIdQuery = new GetBookByIdQuery(bookId);
        Optional<BookResponse> bookResponseOptional = queryGateway.query(getBookByIdQuery,
                ResponseTypes.optionalInstanceOf(BookResponse.class)).join();
        return new ResponseEntity<BookResponse>(bookResponseOptional.get(), HttpStatus.OK);
    }
    
    @GetMapping("/customer/{customerId}")
    public List<BookResponse> getAllBookingsByCustomerId(@PathVariable String customerId) {
        GetBookingsByCustomerIdQuery getBookingsByCustomerIdQuery = new GetBookingsByCustomerIdQuery(customerId);
        List<BookResponse> bookResponses = queryGateway.query(getBookingsByCustomerIdQuery,
                ResponseTypes.multipleInstancesOf(BookResponse.class)).join();
        return bookResponses;
    }
}
