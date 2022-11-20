package com.techonwheels.wheelmanager.community.application.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@Builder
public class CreateCommentCommand {
    @TargetAggregateIdentifier
    private String commentId;
    private String commentDetail;
    private Date publicationDate;
    private String commentCustomerId;
    private String commentVehicleId;
}
