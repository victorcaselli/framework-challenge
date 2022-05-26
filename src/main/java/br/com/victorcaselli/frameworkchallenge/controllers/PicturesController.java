package br.com.victorcaselli.frameworkchallenge.controllers;

import br.com.victorcaselli.frameworkchallenge.dto.request.PictureDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.PictureDtoResponse;
import br.com.victorcaselli.frameworkchallenge.services.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.victorcaselli.frameworkchallenge.utils.UriUtils.getUri;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pictures")
public class PicturesController {


    private final PictureService pictureService;


    @GetMapping("/{id}")
    public ResponseEntity<PictureDtoResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(pictureService.findById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<PictureDtoResponse> save(@RequestBody PictureDtoRequest request, @PathVariable("id") Long photoCollectionId){
        PictureDtoResponse response = pictureService.save(request,photoCollectionId);
        return ResponseEntity.created(getUri(response.getId())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        pictureService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
