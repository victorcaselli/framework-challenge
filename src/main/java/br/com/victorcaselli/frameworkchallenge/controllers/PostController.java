package br.com.victorcaselli.frameworkchallenge.controllers;

import br.com.victorcaselli.frameworkchallenge.dto.request.PostDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.PostDtoResponse;
import br.com.victorcaselli.frameworkchallenge.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;


    @GetMapping
    public ResponseEntity<List<PostDtoResponse>> findAllByUserId(){
        return ResponseEntity.ok().body(postService.findAllByUserId());
    }

    @PostMapping
    public ResponseEntity<PostDtoResponse> save(@RequestBody PostDtoRequest request){
        return ResponseEntity.ok().body(postService.save(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDtoResponse>> findAll(){
        return ResponseEntity.ok().body(postService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDtoResponse> updateById(@PathVariable Long id, @RequestBody PostDtoRequest request){
        return ResponseEntity.ok().body(postService.update(request, id));
    }

//    @GetMapping("/search")
//    public ResponseEntity<PostDtoResponse> search(
//            @RequestParam String text,
//            @RequestParam(required = false) String image
//    ){
//        return ResponseEntity.ok().body(postService.search(text, image));
//    }
}
