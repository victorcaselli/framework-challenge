package br.com.victorcaselli.frameworkchallenge.dto.request;

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
public class CommentDtoRequest implements Serializable {
    private static final long serialVersionUID = -7244409054500661562L;

    private String text;

    public Comment toEntity() {
        return ModelMapperUtils.map(this, Comment.class);
    }
}
