package com.techonwheels.wheelmanager.rent.application.projections;

import com.techonwheels.wheelmanager.profile.domain.repositories.CustomerRepository;
import com.techonwheels.wheelmanager.rent.application.queries.GetBookByIdQuery;
import com.techonwheels.wheelmanager.rent.application.queries.GetBookingsByCustomerIdQuery;
import com.techonwheels.wheelmanager.rent.domain.dto.response.BookResponse;
import com.techonwheels.wheelmanager.rent.domain.repositories.BookRepository;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Book;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookProjection {
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    
    public BookProjection(BookRepository bookRepository, CustomerRepository customerRepository) {
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
    }
    
    @QueryHandler
    public List<BookResponse> on(GetBookingsByCustomerIdQuery getBookingsByCustomerIdQuery) {
        List<Book> books =
                bookRepository.findBooksByBookCustomerId(customerRepository.findById(getBookingsByCustomerIdQuery.customerId).get());
        
        List<BookResponse> bookResponses = books.stream()
                .map(book -> BookResponse
                        .builder()
                        .bookId(book.getBookId())
                        .startDate(book.getStartDate())
                        .endDate(book.getEndDate())
                        .price(book.getPrice())
                        .rentFee(book.getRentFee())
                        .bookCustomerId(book.getBookCustomerId())
                        .bookVehicleId(book.getBookVehicleId())
                        .build())
                .collect(Collectors.toList());
        return bookResponses;
    }
    
    @QueryHandler
    public Optional<BookResponse> on(GetBookByIdQuery getBookByIdQuery) {
        Optional<Book> book = bookRepository.findById(getBookByIdQuery.bookId);
        Optional<BookResponse> bookResponse = book.map(bookResponse1 -> BookResponse
                .builder()
                .bookId(bookResponse1.getBookId())
                .startDate(bookResponse1.getStartDate())
                .endDate(bookResponse1.getEndDate())
                .price(bookResponse1.getPrice())
                .rentFee(bookResponse1.getRentFee())
                .bookCustomerId(bookResponse1.getBookCustomerId())
                .bookVehicleId(bookResponse1.getBookVehicleId())
                .build());
        return bookResponse;
    }
}
