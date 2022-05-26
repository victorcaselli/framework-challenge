package br.com.victorcaselli.frameworkchallenge.services;

import br.com.victorcaselli.frameworkchallenge.dto.request.CommentDtoRequest;
import br.com.victorcaselli.frameworkchallenge.dto.response.CommentDtoResponse;
import br.com.victorcaselli.frameworkchallenge.entities.Comment;
import br.com.victorcaselli.frameworkchallenge.entities.Post;
import br.com.victorcaselli.frameworkchallenge.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.victorcaselli.frameworkchallenge.dto.response.CommentDtoResponse.toDto;
import static br.com.victorcaselli.frameworkchallenge.utils.AuthenticatedUserUtils.getAuthUser;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;


    @Transactional
    public CommentDtoResponse save(CommentDtoRequest request, Long postId){
        Post post = postService.findById(postId).toEntity();

        Comment comment = request.toEntity();
        comment.setPost(post);
        comment.setUser(getAuthUser());

        return toDto(commentRepository.save(comment));
    }

    @Transactional(readOnly = true)
    public List<CommentDtoResponse> findAllByPostId(Long postId){
        return commentRepository.findAllByPostId(postId)
                .stream().map(CommentDtoResponse::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CommentDtoResponse findById(Long id){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        if(!comment.getUser().equals(getAuthUser())){
            throw new IllegalArgumentException("Comment not found");
        }

        return toDto(comment);
    }

    @Transactional
    public void deleteById(Long id){
        findById(id);
        commentRepository.deleteById(id);
    }
}
