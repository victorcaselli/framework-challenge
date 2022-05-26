package br.com.victorcaselli.frameworkchallenge.controllers;

import br.com.victorcaselli.frameworkchallenge.dto.request.CommentDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.CommentDtoResponse;
import br.com.victorcaselli.frameworkchallenge.entities.Comment;
import br.com.victorcaselli.frameworkchallenge.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{id}")
    public ResponseEntity<CommentDtoResponse> save(@RequestBody CommentDtoRequest request, @PathVariable("id") Long postId){
        return ResponseEntity.ok().body(commentService.save(request, postId));
    }
}
