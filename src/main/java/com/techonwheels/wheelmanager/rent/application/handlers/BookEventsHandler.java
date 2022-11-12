package com.techonwheels.wheelmanager.rent.application.handlers;

import com.techonwheels.wheelmanager.profile.domain.repositories.CustomerRepository;
import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.application.events.BookCreatedEvent;
import com.techonwheels.wheelmanager.rent.domain.repositories.BookRepository;
import com.techonwheels.wheelmanager.rent.domain.repositories.VehicleRepository;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Book;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ProcessingGroup("book")
public class BookEventsHandler {
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;
    
    public BookEventsHandler(BookRepository bookRepository, CustomerRepository customerRepository,
                             VehicleRepository vehicleRepository) {
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.vehicleRepository = vehicleRepository;
    }
    
    @EventHandler
    public void on(BookCreatedEvent bookCreatedEvent) {
        Book book = new Book();
        BeanUtils.copyProperties(bookCreatedEvent, book);
        Optional<Customer> customerOptional = customerRepository.findById(bookCreatedEvent.getBookCustomerId());
        customerOptional.ifPresent(book::setBookCustomerId);
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(bookCreatedEvent.getBookVehicleId());
        vehicleOptional.ifPresent(book::setBookVehicleId);
        bookRepository.save(book);
    }
}
