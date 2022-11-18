package com.techonwheels.wheelmanager.community.application.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreatedEvent {
    private String commentId;
    private String commentDetail;
    private Date publicationDate;
    private String commentCustomerId;
    private String commentVehicleId;
}
