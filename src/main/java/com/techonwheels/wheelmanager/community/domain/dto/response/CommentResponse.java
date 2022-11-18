package com.techonwheels.wheelmanager.community.domain.dto.response;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CommentResponse {
    private String commentId;
    private String commentDetail;
    private Date publicationDate;
    private Customer commentCustomerId;
    private Vehicle commentVehicleId;
}
