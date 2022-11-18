package com.techonwheels.wheelmanager.community.presentation.rest.controllers;

import com.techonwheels.wheelmanager.community.application.commands.CreateCommentCommand;
import com.techonwheels.wheelmanager.community.domain.dto.request.CommentRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/comments")
public class CommentCommandsController {
    private final CommandGateway commandGateway;
    
    public CommentCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
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
