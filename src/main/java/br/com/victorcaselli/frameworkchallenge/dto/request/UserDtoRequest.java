package br.com.victorcaselli.frameworkchallenge.dto.request;

import br.com.victorcaselli.frameworkchallenge.entities.User;
import br.com.victorcaselli.frameworkchallenge.utils.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDtoRequest implements Serializable {

    private static final long serialVersionUID = 4252326377780763284L;

    private String fullName;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 6)
    private String password;


    public UserDtoRequest toDto(User user){
        return ModelMapperUtils.map(user, UserDtoRequest.class);
    }

    public User toEntity(){
        return ModelMapperUtils.map(this, User.class);
    }
}
