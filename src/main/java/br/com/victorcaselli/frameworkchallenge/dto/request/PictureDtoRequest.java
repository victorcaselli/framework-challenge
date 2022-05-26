package br.com.victorcaselli.frameworkchallenge.dto.request;

import br.com.victorcaselli.frameworkchallenge.entities.Picture;
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
public class PictureDtoRequest implements Serializable {
    private static final long serialVersionUID = 9118270563155099731L;

    private String base64;
    private String description;

    public Picture toEntity(){
        return ModelMapperUtils.map(this, Picture.class);
    }
}
