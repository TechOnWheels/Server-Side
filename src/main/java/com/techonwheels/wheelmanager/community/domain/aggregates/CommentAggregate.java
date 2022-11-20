package com.techonwheels.wheelmanager.community.domain.aggregates;

import com.techonwheels.wheelmanager.community.application.commands.CreateCommentCommand;
import com.techonwheels.wheelmanager.community.application.events.CommentCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class CommentAggregate {
    @AggregateIdentifier
    private String commentId;
    private String commentDetail;
    private Date publicationDate;
    private String commentCustomerId;
    private String commentVehicleId;
    
    public CommentAggregate() {
    }
    
    @CommandHandler
    public CommentAggregate(CreateCommentCommand createCommentCommand) {
        CommentCreatedEvent commentCreatedEvent = new CommentCreatedEvent();
        BeanUtils.copyProperties(createCommentCommand, commentCreatedEvent);
        AggregateLifecycle.apply(commentCreatedEvent);
    }
    
    @EventSourcingHandler
    public void on(CommentCreatedEvent commentCreatedEvent) {
        this.commentId = commentCreatedEvent.getCommentId();
        this.commentDetail = commentCreatedEvent.getCommentDetail();
        this.publicationDate = commentCreatedEvent.getPublicationDate();
        this.commentCustomerId = commentCreatedEvent.getCommentCustomerId();
        this.commentVehicleId = commentCreatedEvent.getCommentVehicleId();
    }
}
