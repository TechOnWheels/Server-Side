package com.techonwheels.wheelmanager.rent.domain.aggregates;

import com.techonwheels.wheelmanager.rent.application.commands.CreateBookCommand;
import com.techonwheels.wheelmanager.rent.application.events.BookCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

@Aggregate
public class BookingAggregate {
    @AggregateIdentifier
    private String bookId;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private BigDecimal rentFee;
    private String bookCustomerId;
    private String bookVehicleId;
    
    public BookingAggregate() {
    }
    
    @CommandHandler
    public BookingAggregate(CreateBookCommand createBookCommand) {
        BookCreatedEvent bookCreatedEvent = new BookCreatedEvent();
        BeanUtils.copyProperties(createBookCommand, bookCreatedEvent);
        AggregateLifecycle.apply(bookCreatedEvent);
    }
    
    @EventSourcingHandler
    public void on(BookCreatedEvent bookCreatedEvent) {
        this.bookId = bookCreatedEvent.getBookId();
        this.startDate = bookCreatedEvent.getStartDate();
        this.endDate = bookCreatedEvent.getEndDate();
        this.price = bookCreatedEvent.getPrice();
        this.rentFee = bookCreatedEvent.getRentFee();
        this.bookCustomerId = bookCreatedEvent.getBookCustomerId();
        this.bookVehicleId = bookCreatedEvent.getBookVehicleId();
    }
}
