package br.com.victorcaselli.frameworkchallenge.dto.response;

import br.com.victorcaselli.frameworkchallenge.entities.User;
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
public class UserDtoResponse implements Serializable {

    private static final long serialVersionUID = 3573613730395319622L;

    private Long id;
    private String fullName;
    private String email;

    public static UserDtoResponse toDto(User user) {
        return ModelMapperUtils.map(user, UserDtoResponse.class);
    }

    public User toEntity(){
        return ModelMapperUtils.map(this, User.class);
    }
}
