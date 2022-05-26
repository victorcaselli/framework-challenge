package br.com.victorcaselli.frameworkchallenge.dto.response;

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
public class PictureDtoResponse implements Serializable {
    private static final long serialVersionUID = 9118270563155099731L;

    private Long id;
    private String base64;
    private String description;


    public static PictureDtoResponse toDto(Picture picture){
        return ModelMapperUtils.map(picture, PictureDtoResponse.class);
    }
}
