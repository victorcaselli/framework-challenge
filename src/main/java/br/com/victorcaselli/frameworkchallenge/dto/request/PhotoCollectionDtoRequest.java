package br.com.victorcaselli.frameworkchallenge.dto.request;


import br.com.victorcaselli.frameworkchallenge.dto.response.PictureDtoResponse;
import br.com.victorcaselli.frameworkchallenge.entities.PhotoCollection;
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
public class PhotoCollectionDtoRequest implements Serializable {
    private static final long serialVersionUID = -7145203904246710360L;

    private String title;
    private String description;

    public PhotoCollection toEntity() {
        return ModelMapperUtils.map(this, PhotoCollection.class);
    }
}
