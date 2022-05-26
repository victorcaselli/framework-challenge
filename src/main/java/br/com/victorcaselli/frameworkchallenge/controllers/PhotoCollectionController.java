package br.com.victorcaselli.frameworkchallenge.controllers;

import br.com.victorcaselli.frameworkchallenge.dto.request.PhotoCollectionDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.PhotoCollectionDtoResponse;
import br.com.victorcaselli.frameworkchallenge.services.PhotoCollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static br.com.victorcaselli.frameworkchallenge.utils.UriUtils.getUri;

@RequiredArgsConstructor
@RestController
@RequestMapping("/photo-collection")
public class PhotoCollectionController {

    private final PhotoCollectionService photoCollectionService;

    @GetMapping
    public ResponseEntity<List<PhotoCollectionDtoResponse>> findAll(){
        return ResponseEntity.ok().body(photoCollectionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoCollectionDtoResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(photoCollectionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PhotoCollectionDtoResponse> save (@RequestBody PhotoCollectionDtoRequest request){
        PhotoCollectionDtoResponse response = photoCollectionService.save(request);

        return ResponseEntity.created(getUri(response.getId())).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        photoCollectionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
