package br.com.victorcaselli.frameworkchallenge.controllers;

import br.com.victorcaselli.frameworkchallenge.dto.request.UserDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.UserDtoResponse;
import br.com.victorcaselli.frameworkchallenge.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDtoResponse> save(@RequestBody UserDtoRequest request){
        return ResponseEntity.ok().body(userService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }
}
