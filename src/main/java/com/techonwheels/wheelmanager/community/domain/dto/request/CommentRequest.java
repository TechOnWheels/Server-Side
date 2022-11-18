package com.techonwheels.wheelmanager.community.domain.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CommentRequest {
    private String commentDetail;
    private Date publicationDate;
    private String commentCustomerId;
    private String commentVehicleId;
}
