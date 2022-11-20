package com.techonwheels.wheelmanager.community.presentation.rest.controllers;

import com.techonwheels.wheelmanager.community.application.commands.CreateCommentCommand;
import com.techonwheels.wheelmanager.community.domain.dto.request.CommentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Tag(name = "Comments Commands")
@RestController
@RequestMapping("/api/comments")
public class CommentCommandsController {
    private final CommandGateway commandGateway;
    
    public CommentCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    @Operation(summary = "Post Comment")
    public String addComment(@RequestBody CommentRequest commentRequest) {
        CreateCommentCommand createCommentCommand =
                CreateCommentCommand
                        .builder()
                        .commentId(UUID.randomUUID().toString())
                        .commentDetail(commentRequest.getCommentDetail())
                        .publicationDate(commentRequest.getPublicationDate())
                        .commentCustomerId(commentRequest.getCommentCustomerId())
                        .commentVehicleId(commentRequest.getCommentVehicleId())
                        .build();
        String result = commandGateway.sendAndWait(createCommentCommand);
        return result;
    }
}
