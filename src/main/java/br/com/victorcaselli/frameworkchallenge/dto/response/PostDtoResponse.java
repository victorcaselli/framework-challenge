package br.com.victorcaselli.frameworkchallenge.dto.response;

import br.com.victorcaselli.frameworkchallenge.entities.Post;
import br.com.victorcaselli.frameworkchallenge.utils.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostDtoResponse implements Serializable {
    private static final long serialVersionUID = -2992980877484808021L;

    private Long id;
    private String text;
    private List<String> images = new ArrayList<>();
    private List<String> links = new ArrayList<>();
    private List<CommentDtoResponse> comments = new ArrayList<>();


    public static PostDtoResponse toDto(Post post){
        return ModelMapperUtils.map(post, PostDtoResponse.class);
    }

    public Post toEntity() {
        return ModelMapperUtils.map(this, Post.class);
    }
}
