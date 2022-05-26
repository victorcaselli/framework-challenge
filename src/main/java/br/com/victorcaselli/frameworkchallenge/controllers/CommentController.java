package br.com.victorcaselli.frameworkchallenge.controllers;

import br.com.victorcaselli.frameworkchallenge.dto.request.CommentDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.CommentDtoResponse;
import br.com.victorcaselli.frameworkchallenge.entities.Comment;
import br.com.victorcaselli.frameworkchallenge.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.victorcaselli.frameworkchallenge.utils.UriUtils.getUri;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{id}")
    public ResponseEntity<CommentDtoResponse> save(@RequestBody CommentDtoRequest request, @PathVariable("id") Long postId){
        CommentDtoResponse response = commentService.save(request, postId);

        return ResponseEntity.created(getUri(response.getId())).body(response);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<CommentDtoResponse>> findAllByPostId(@PathVariable("id") Long postId){
        return ResponseEntity.ok().body(commentService.findAllByPostId(postId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDtoResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(commentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable  Long id){
        commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
