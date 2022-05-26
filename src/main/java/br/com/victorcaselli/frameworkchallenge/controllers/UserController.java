package br.com.victorcaselli.frameworkchallenge.controllers;

import br.com.victorcaselli.frameworkchallenge.dto.request.UserDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.UserDtoResponse;
import br.com.victorcaselli.frameworkchallenge.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static br.com.victorcaselli.frameworkchallenge.utils.UriUtils.getUri;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDtoResponse> save(@RequestBody UserDtoRequest request){
        UserDtoResponse response = userService.save(request);

        return ResponseEntity.created(getUri(response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }
}
