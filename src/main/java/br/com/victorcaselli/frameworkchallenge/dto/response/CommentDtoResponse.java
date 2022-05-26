package br.com.victorcaselli.frameworkchallenge.dto.response;

import br.com.victorcaselli.frameworkchallenge.dto.request.CommentDtoRequest;
import br.com.victorcaselli.frameworkchallenge.entities.Comment;
import br.com.victorcaselli.frameworkchallenge.utils.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentDtoResponse implements Serializable {
    private static final long serialVersionUID = -7244409054500661562L;

    private Long id;
    private String text;
    private UserDtoResponse user;


    public static CommentDtoResponse toDto(Comment comment){
        return ModelMapperUtils.map(comment, CommentDtoResponse.class);
    }
}
