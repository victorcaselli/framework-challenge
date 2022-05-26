package br.com.victorcaselli.frameworkchallenge.services;

import br.com.victorcaselli.frameworkchallenge.dto.request.PostDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.PostDtoResponse;
import br.com.victorcaselli.frameworkchallenge.entities.Post;
import br.com.victorcaselli.frameworkchallenge.entities.User;
import br.com.victorcaselli.frameworkchallenge.repositories.PostRepository;
import br.com.victorcaselli.frameworkchallenge.services.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.victorcaselli.frameworkchallenge.dto.response.PostDtoResponse.toDto;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    private final UserService userService;



    @Transactional(readOnly = true)
    public List<PostDtoResponse> findAllByUserId(){

        return postRepository.findAllByUserId(getAuthenticatedUser().getId())
                .stream().map(PostDtoResponse::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostDtoResponse findById(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        if(!post.getUser().equals(getAuthenticatedUser())){
            return null;
        }

        return toDto(post);
    }

//    @Transactional(readOnly = true)
//    public PostDtoResponse search(String text, String image){
//        return toDto(postRepository.findByParams(text, image));
//    }


    @Transactional
    public PostDtoResponse save(PostDtoRequest request){
        Post post = request.toEntity();
        post.setUser(getAuthenticatedUser());
        return toDto(postRepository.save(post));
    }

    @Transactional
    public PostDtoResponse update(PostDtoRequest request, Long id){
        findById(id);

        Post updated = request.toEntity();
        updated.setId(id);

        return toDto(postRepository.save(updated));
    }

    @Transactional
    public void deletePostById(Long id){
        findById(id);
        postRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public User getAuthenticatedUser(){
        return userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

}
