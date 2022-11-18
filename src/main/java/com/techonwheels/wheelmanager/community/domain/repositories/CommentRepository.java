package com.techonwheels.wheelmanager.community.domain.repositories;

import com.techonwheels.wheelmanager.community.infrastructure.data.Comment;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    List<Comment> findCommentsByCommentVehicleId(Vehicle vehicleCustomerId);
}
